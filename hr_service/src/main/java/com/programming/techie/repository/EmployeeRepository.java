package com.programming.techie.repository;

import com.programming.techie.model.Employee;
import com.programming.techie.model.Leaves;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByUserName(String username);

}
