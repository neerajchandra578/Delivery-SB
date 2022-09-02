package com.parcel.delivery.controller;

import com.parcel.delivery.error.DepartmentNotFound;
import com.parcel.delivery.model.User;
import com.parcel.delivery.model.Vechile;
import com.parcel.delivery.service.VechileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins={"http://localhost:3000", "http://3.16.158.189:3000"})
@RestController
public class VechileController {

    @Autowired
    private VechileService vechileService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(VechileController.class);

    @PostMapping("/vechiles")
    public Vechile saveUser(@Valid @RequestBody Vechile department) {
        LOGGER.info("Inside saveVechile of VechileController");
        return vechileService.saveVechile(department);
    }

    @GetMapping("/vechiles")
    public List<Vechile> fetchVechileList() {
        LOGGER.info("Inside fetchVechileList of VechileController");
        return vechileService.fetchVechileList();
    }

    @GetMapping("/vechiles/available")
    public List<Vechile> fetchAvailableVechileList() {
        LOGGER.info("Inside fetchVechileList of VechileController");
        return vechileService.fetchAvialableVechileList();
    }

    @GetMapping("/vechiles/{id}")
    public Vechile fetchVechileById(@PathVariable("id") Long departmentId)
            throws DepartmentNotFound {
        return vechileService.fetchvById(departmentId);
    }

    @DeleteMapping("/vechiles/{id}")
    public String deleteVechileById(@PathVariable("id") Long departmentId) {
        vechileService.deleteVechileById(departmentId);
        return "User deleted Successfully!!";
    }

    @PutMapping("/vechiles/{id}")
    public Vechile updateVechile(@PathVariable("id") Long departmentId,
                                 @RequestBody Vechile department) {
        return vechileService.updatev(departmentId,department);
    }
}
