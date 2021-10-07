package com.programming.techie.service;


import com.programming.techie.dto.*;
import com.programming.techie.model.*;
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
            dto.setId(employee.getId());
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

    public EmployeeFullResponseDto get(String username) {

        Employee employee = employeeRepository.findByUserName(username);
        EmployeeFullResponseDto dto = new EmployeeFullResponseDto();
        dto.setUser_name(employee.getUser_name());
        dto.setLastName(employee.getLastName());
        dto.setFirstName(employee.getFirstName());
        dto.setMiddleName(employee.getMiddleName());
        dto.setAddress(employee.getAddress());
        dto.setActive(employee.getActive());
        dto.setContact(employee.getContact());
        dto.setDateOfBirth(employee.getDateOfBirth());
        dto.setEmail(employee.getEmail());
        dto.setExitDate(employee.getExitDate());
        dto.setJoiningDate(employee.getJoiningDate());
        dto.setId(employee.getId());

        Department department =employee.getDepartment();
        dto.setDepartment(department.getName());

        Designation designation = employee.getDesignation();
        dto.setDesignation(designation.getName());

        Grade grade = employee.getGrade();
        dto.setGrade(grade.getName());

        List<Leaves> leavesList = employee.getLeavesList();
        List<LeavesResponseDto> list = new ArrayList();
        for (Leaves leaves :
                leavesList) {
            LeavesResponseDto _dto = new LeavesResponseDto();
            _dto.setEmployee_name(leaves.getApproval());
            _dto.setEnd_date(leaves.getEnd_date());
            _dto.setId(leaves.getId());
            _dto.setStart_date(leaves.getStart_date());
            _dto.setSubmit_date(leaves.getSubmit_date());
            _dto.setType(leaves.getType().getName());

            list.add(_dto);
        }

        dto.setLeavesList(list);

        List<Month_salary> month_salaryList = employee.getMonth_salaryList();
        List<Month_salaryDto> llist = new ArrayList();
        for (Month_salary month_salary :
                month_salaryList) {
            Month_salaryDto _dto = new Month_salaryDto();
            _dto.setAmount(month_salary.getAmount());
            _dto.setEmployee_name(month_salary.getEmployee().getFirstName());
            _dto.setId(month_salary.getId());
            _dto.setMonth(month_salary.getMonth());
            _dto.setYear(month_salary.getYear());

            llist.add(_dto);
        }
     dto.setMonth_salaryList(llist);

        return dto;
    }
}
