package com.programming.techie.service;


import com.programming.techie.dto.EmployeeFullResponseDto;
import com.programming.techie.dto.EmployeeRequestDto;
import com.programming.techie.dto.EmployeeResponseDto;
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

import java.util.ArrayList;
import java.util.List;
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

    public void create(EmployeeRequestDto employeeRequestDto) {

        Employee employee = new Employee();

        employee.setUser_name(employeeRequestDto.getUser_name());
        employee.setFirstName(employeeRequestDto.getFirstName());
        employee.setLastName(employeeRequestDto.getLastName());
        employee.setMiddleName(employee.getMiddleName());
        employee.setDateOfBirth(employeeRequestDto.getDateOfBirth());
        employee.setActive(employeeRequestDto.getActive());
        employee.setEmail(employeeRequestDto.getEmail());
        employee.setJoiningDate(employeeRequestDto.getJoiningDate());
        employee.setExitDate(employeeRequestDto.getExitDate());
        employee.setAddress(employeeRequestDto.getAddress());
        employee.setContact(employeeRequestDto.getContact());


        Optional<Department> department = departmentRepository.findById(employeeRequestDto.getDepartment());
        employee.setDepartment(department.get());


        Optional<Designation> designation = designationRepository.findById(employeeRequestDto.getDesignation());
        employee.setDesignation(designation.get());


        Optional<Grade> grade = gradeRepository.findById(employeeRequestDto.getGrade());
        employee.setGrade(grade.get());

        employeeRepository.save(employee);

    }

    public List<EmployeeResponseDto> getAll() {

        List<Employee> employeeList =employeeRepository.findAll();
        List<EmployeeResponseDto> list = new ArrayList();
        for (Employee employee:
             employeeList) {

            EmployeeResponseDto dto = new EmployeeResponseDto();
            dto.setActive(employee.getActive());
            dto.setAddress(employee.getAddress());
            dto.setContact(employee.getContact());
            dto.setFirstName(employee.getFirstName());
            dto.setLastName(employee.getLastName());

            Department department =employee.getDepartment();
            dto.setDepartment(department.getName());

            Designation designation = employee.getDesignation();
            dto.setDesignation(designation.getName());

            Grade grade = employee.getGrade();
            dto.setGrade(grade.getName());
            list.add(dto);

        }

           return list;

    }

    public EmployeeFullResponseDto get(Long id) {

        Optional<Employee> employee = employeeRepository.findById(id);
        EmployeeFullResponseDto dto = new EmployeeFullResponseDto();
        dto.setUser_name(employee.get().getUser_name());
        dto.setLastName(employee.get().getLastName());
        dto.setFirstName(employee.get().getFirstName());
        dto.setMiddleName(employee.get().getMiddleName());
        dto.setAddress(employee.get().getAddress());
        dto.setActive(employee.get().getActive());
        dto.setContact(employee.get().getContact());
        dto.setDateOfBirth(employee.get().getDateOfBirth());
        dto.setEmail(employee.get().getEmail());
        dto.setExitDate(employee.get().getExitDate());
        dto.setJoiningDate(employee.get().getJoiningDate());

        Department department =(employee.get()).getDepartment();
        dto.setDepartment(department.getName());

        Designation designation = (employee.get()).getDesignation();
        dto.setDesignation(designation.getName());

        Grade grade = (employee.get()).getGrade();
        dto.setGrade(grade.getName());


        return dto;
    }
}
