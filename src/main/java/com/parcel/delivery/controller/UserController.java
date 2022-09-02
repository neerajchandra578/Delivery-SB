package com.parcel.delivery.controller;

import com.parcel.delivery.error.DepartmentNotFound;
import com.parcel.delivery.model.Department;
import com.parcel.delivery.model.LoginRequestBody;
import com.parcel.delivery.model.ResponseBody;
import com.parcel.delivery.model.User;
import com.parcel.delivery.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins={"http://localhost:3000", "http://3.16.158.189:3000"})
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(UserController.class);

    @PostMapping("/users")
    public User saveUser(@Valid @RequestBody User department) {
        LOGGER.info("Inside saveUser of UserController");
        return userService.saveUser(department);
    }

    @GetMapping("/users")
    public List<User> fetchUserList() {
        LOGGER.info("Inside fetchUserList of UserController");
        return userService.fetchUserList();
    }

    @GetMapping("/users/available")
    public List<User> fetchAvailableUserList() {
        LOGGER.info("Inside fetchUserList of UserController");
        return userService.fetchAvailableUserList();
    }


    @GetMapping("/users/{id}")
    public User fetchDepartmentById(@PathVariable("id") Long departmentId)
            throws DepartmentNotFound {
        return userService.fetchvById(departmentId);
    }

    @PostMapping("/users/login")
    public ResponseBody fetchDepartmentById(@Valid @RequestBody LoginRequestBody loginRequestBody)
            throws DepartmentNotFound {
        LOGGER.info("Login Req ",loginRequestBody.toString());
        return userService.fetchvByUserNamePassword(loginRequestBody.getUserName(),loginRequestBody.getPassword());
    }


    @DeleteMapping("/users/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        userService.deleteVechileById(departmentId);
        return "User deleted Successfully!!";
    }

    @PutMapping("/users/{id}")
    public User updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody User department) {
        return userService.updateUser(departmentId,department);
    }
}
