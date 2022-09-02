package com.parcel.delivery.service;

import com.parcel.delivery.error.DepartmentNotFound;
import com.parcel.delivery.model.Vechile;
import com.parcel.delivery.repo.VechileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class VechileService {
    @Autowired
    private VechileRepo vechileRepo;


    public Vechile saveVechile(Vechile department) {
        return vechileRepo.save(department);
    }


    public List<Vechile> fetchVechileList() {
        return vechileRepo.findAll();
    }

    public List<Vechile> fetchAvialableVechileList() {
        return vechileRepo.findAvailableVechiles();
    }


    public Vechile fetchvById(Long departmentId) throws DepartmentNotFound {
        Optional<Vechile> department =
                vechileRepo.findById(departmentId);

        if(!department.isPresent()) {
            throw new DepartmentNotFound("Department Not Available");
        }

        return  department.get();
    }


    public void deleteVechileById(Long departmentId) {
        vechileRepo.deleteById(departmentId);
    }


    public Vechile updatev(Long departmentId, Vechile department) {
        Vechile depDB = vechileRepo.findById(departmentId).get();

        if(Objects.nonNull(department.getVechileName()) &&
                !"".equalsIgnoreCase(department.getVechileName())) {
            depDB.setVechileName(department.getVechileName());
        }

        if(Objects.nonNull(department.getVechileRegNumber()) &&
                !"".equalsIgnoreCase(department.getVechileRegNumber())) {
            depDB.setVechileRegNumber(department.getVechileRegNumber());
        }

/*        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }*/

        return vechileRepo.save(depDB);
    }


    public Vechile updateVechileActiveStatus(Vechile newVechile, boolean status) {
        newVechile.setActive(status);
        return vechileRepo.save(newVechile);
    }

    /*public Vechile fetchDepartmentByName(String departmentName) {
        return vechileRepo.findByDepartmentNameIgnoreCase(departmentName);
    }*/
}
