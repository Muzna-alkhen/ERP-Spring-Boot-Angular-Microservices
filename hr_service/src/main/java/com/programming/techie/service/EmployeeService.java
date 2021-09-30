package com.programming.techie.service;


import com.programming.techie.model.Designation;
import com.programming.techie.model.Employee;
import com.programming.techie.repository.DesignationRepository;
import com.programming.techie.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

   @Autowired
    EmployeeRepository employeeRepository;

   @Autowired
    DesignationRepository designationRepository;

    public boolean checkManager (Long id)
    {
        Optional<Employee> employee = employeeRepository.findById(id);


        if ((employee.get().getDesignation().getId().equals(2L)) ||

        (employee.get().getDesignation().getId().equals(3L)) ||

        (employee.get().getDesignation().getId().equals(4L))

        )
        {

            return true;

        }

        else {

            return false;
        }


    }
}
