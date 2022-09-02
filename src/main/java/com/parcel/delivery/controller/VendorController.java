package com.parcel.delivery.controller;

import com.parcel.delivery.error.DepartmentNotFound;
import com.parcel.delivery.model.Vechile;
import com.parcel.delivery.model.Vendor;
import com.parcel.delivery.service.VechileService;
import com.parcel.delivery.service.VendorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins={"http://localhost:3000", "http://3.16.158.189:3000"})
@RestController
public class VendorController {


    @Autowired
    private VendorService vechileService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(VendorController.class);

    @PostMapping("/vendor")
    public Vendor saveUser(@Valid @RequestBody Vendor department) {
        LOGGER.info("Inside saveVechile of VechileController");
        return vechileService.saveVechile(department);
    }

    @GetMapping("/vendorList")
    public List<Vendor> fetchVechileList() {
        LOGGER.info("Inside fetch Vendor List of VechileController");
        return vechileService.fetchVechileList();
    }

    @GetMapping("/vendor/{id}")
    public Vendor fetchVechileById(@PathVariable("id") Long departmentId)
            throws DepartmentNotFound {
        return vechileService.fetchvById(departmentId);
    }

    @DeleteMapping("/vendor/{id}")
    public String deleteVechileById(@PathVariable("id") Long departmentId) {
        vechileService.deleteVechileById(departmentId);
        return "User deleted Successfully!!";
    }

    @PutMapping("/vendor/{id}")
    public Vendor updateVechile(@PathVariable("id") Long departmentId,
                                @RequestBody Vendor department) {
        return vechileService.updatev(departmentId,department);
    }
}
