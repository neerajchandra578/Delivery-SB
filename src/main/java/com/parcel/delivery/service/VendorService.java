package com.parcel.delivery.service;

import com.parcel.delivery.error.DepartmentNotFound;
import com.parcel.delivery.model.Vechile;
import com.parcel.delivery.model.Vendor;
import com.parcel.delivery.repo.VechileRepo;
import com.parcel.delivery.repo.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class VendorService {
    @Autowired
    private VendorRepo vechileRepo;


    public Vendor saveVechile(Vendor department) {
        return vechileRepo.save(department);
    }


    public List<Vendor> fetchVechileList() {
        return vechileRepo.findAll();
    }


    public Vendor fetchvById(Long departmentId) throws DepartmentNotFound {
        Optional<Vendor> department =
                vechileRepo.findById(departmentId);

        if(!department.isPresent()) {
            throw new DepartmentNotFound("Department Not Available");
        }

        return  department.get();
    }


    public void deleteVechileById(Long departmentId) {
        vechileRepo.deleteById(departmentId);
    }


    public Vendor updatev(Long departmentId, Vendor department) {
     //   Vendor depDB = vechileRepo.findById(departmentId).get();

        /*if(Objects.nonNull(department.getVechileName()) &&
                !"".equalsIgnoreCase(department.getVechileName())) {
            depDB.setVechileName(department.getVechileName());
        }*/

/*        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }*/

        return vechileRepo.save(department);
    }

}
