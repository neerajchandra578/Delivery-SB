package com.parcel.delivery.controller;

import com.parcel.delivery.error.DepartmentNotFound;
import com.parcel.delivery.model.Employee;
import com.parcel.delivery.model.TResInter;
import com.parcel.delivery.model.TestResponse;
import com.parcel.delivery.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/t1")
    public String testt(){
        return "test starting";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> tes(){
        List<Employee> employeeList = testService.getAllEmp();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/findCustom")
    public ResponseEntity<List<TResInter>> tesC(){
        List<TResInter> employeeList = testService.getAllCustom();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/findCustomer/{id}")
    public ResponseEntity<Employee> findCu(@PathVariable("id") long id) throws DepartmentNotFound {
        Employee employee = testService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /*@GetMapping("/findCustom")
    public ResponseEntity<Object> tesC(){
        Object employeeList = testService.getAllCustom();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }*/
}
