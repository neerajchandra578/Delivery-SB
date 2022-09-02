package com.parcel.delivery.service;

import com.parcel.delivery.error.DepartmentNotFound;
import com.parcel.delivery.model.Employee;
import com.parcel.delivery.model.TResInter;
import com.parcel.delivery.model.TestResponse;
import com.parcel.delivery.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    EmployeeRepo employeeRepo;

    public List<Employee> getAllEmp(){
        List<Employee> employeeList = employeeRepo.findAll();
        return employeeList;
    }

    public List<TResInter> getAllCustom(){
        List<TResInter> employeeList = employeeRepo.findCustomeQ();
        return employeeList;
    }

    public Employee getEmployeeById(long id ) throws DepartmentNotFound {
        Optional<Employee> employee = employeeRepo.findById(id);
        if(!employee.isPresent()){
            throw new DepartmentNotFound("Test ex Please use other Id");
        }

        return employee.get();
    }

/*public Object getAllCustom(){
    Object employeeList = employeeRepo.findCustomeQ();
    return employeeList;
}*/
}
