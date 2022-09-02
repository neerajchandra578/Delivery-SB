package com.parcel.delivery.repo;

import com.parcel.delivery.model.Employee;
import com.parcel.delivery.model.TResInter;
import com.parcel.delivery.model.TestResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

//    @Query(value = "select emp.id,emp.name,dpt.name as deptname from employee emp join department dpt on dpt.id = emp.dept_id",nativeQuery = true)
/*    @Query(value = "select emp.id,emp.name,emp.department.name as deptname from employee emp")
    Object findCustomeQ();*/
//    @Query(value = "select emp.id,emp.name,emp.department.name as deptname from employee emp")
//    @Query(value = "select id , name from employee")
    @Query(value = "select emp.id as id,emp.name as name ,emp.department.name as dept from employee emp")
    List<TResInter> findCustomeQ();
}
