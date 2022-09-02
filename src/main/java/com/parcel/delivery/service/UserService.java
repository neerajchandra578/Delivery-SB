package com.parcel.delivery.service;

import com.parcel.delivery.error.DepartmentNotFound;
import com.parcel.delivery.model.ResponseBody;
import com.parcel.delivery.model.User;
import com.parcel.delivery.model.Vechile;
import com.parcel.delivery.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;


    public User saveUser(User department) {
        return userRepo.save(department);
    }


    public List<User> fetchUserList() {
        return userRepo.findAll();
    }

    public List<User> fetchAvailableUserList() {
        return userRepo.findAvailableUsers();
    }


    public User fetchvById(Long departmentId) throws DepartmentNotFound {
        Optional<User> department =
                userRepo.findById(departmentId);

        if(!department.isPresent()) {
            throw new DepartmentNotFound("Department Not Available");
        }

        return  department.get();
    }

    public ResponseBody fetchvByUserNamePassword(String userName, String password) throws DepartmentNotFound {
        Optional<User> department =
                userRepo.findByUserNamePassword(userName,password);

        if(!department.isPresent()) {
            throw new DepartmentNotFound("Department Not Available");
        }

        return  new ResponseBody("Success","201",true,department.get());
    }


    public void deleteVechileById(Long departmentId) {
        userRepo.deleteById(departmentId);
    }


    public User updateUser(Long departmentId, User department) {
       // User depDB = userRepo.findById(departmentId).get();

/*        if(Objects.nonNull(department.getVechileName()) &&
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

        return userRepo.save(department);
    }

    public User updateUserActiveStatus(User newUser, boolean status) {
        newUser.setActive(status);
        return userRepo.save(newUser);
    }
}
