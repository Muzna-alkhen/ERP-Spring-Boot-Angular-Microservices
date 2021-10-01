package com.programming.techie.service;


import com.programming.techie.dto.EmployeeDto;
import com.programming.techie.model.Department;
import com.programming.techie.model.Designation;
import com.programming.techie.model.Employee;
import com.programming.techie.model.Grade;
import com.programming.techie.repository.DepartmentRepository;
import com.programming.techie.repository.DesignationRepository;
import com.programming.techie.repository.EmployeeRepository;
import com.programming.techie.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

   @Autowired
    EmployeeRepository employeeRepository;

   @Autowired
    DesignationRepository designationRepository;

   @Autowired
    DepartmentRepository departmentRepository;

   @Autowired
   GradeRepository gradeRepository;




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

    public void create(EmployeeDto employeeDto) {

        Employee employee = new Employee();

        employee.setUser_name(employeeDto.getUser_name());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setMiddleName(employee.getMiddleName());
        employee.setDateOfBirth(employeeDto.getDateOfBirth());
        employee.setActive(employeeDto.getActive());
        employee.setEmail(employeeDto.getEmail());
        employee.setJoiningDate(employeeDto.getJoiningDate());
        employee.setExitDate(employeeDto.getExitDate());
        employee.setAddress(employeeDto.getAddress());
        employee.setContact(employeeDto.getContact());


        Optional<Department> department = departmentRepository.findById(employeeDto.getDepartment());
        employee.setDepartment(department.get());


        Optional<Designation> designation = designationRepository.findById(employeeDto.getDesignation());
        employee.setDesignation(designation.get());


        Optional<Grade> grade = gradeRepository.findById(employeeDto.getGrade());
        employee.setGrade(grade.get());

        employeeRepository.save(employee);

    }
}
