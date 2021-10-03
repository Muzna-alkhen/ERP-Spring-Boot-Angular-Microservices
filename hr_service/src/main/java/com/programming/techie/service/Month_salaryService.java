package com.programming.techie.service;

import com.programming.techie.model.*;
import com.programming.techie.mq.AllPayrollMsg;
import com.programming.techie.repository.AttendanceRepository;
import com.programming.techie.repository.EmployeeRepository;
import com.programming.techie.repository.LeavesRepository;
import com.programming.techie.repository.Month_salaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Month_salaryService {



    @Autowired
    Month_salaryRepository month_salaryRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    AttendanceRepository attendanceRepository;


    @Autowired
    LeavesRepository leavesRepository;

    public void generate() {
        List<Employee> employees = employeeRepository.findAll();
        AllPayrollMsg msg = new AllPayrollMsg();


        for (Employee employee:employees
             ) {

        List<Attendance> attendanceList = attendanceRepository.findByEmployee(employee);
        int attendanceCount = attendanceList.size();

        List<Leaves> leavesList =leavesRepository.findByEmployee(employee);
        int leavesCount = leavesList.size();

        int gradeConstant = employee.getGrade().getConstant();

        int salary = (gradeConstant * attendanceCount) - leavesCount;

        Month_salary month_salary = new  Month_salary();

        month_salary.setYear("2021");
        month_salary.setMonth("01");

        month_salary.setAmount(salary);

        month_salary.setEmployee(employee);

        month_salary.setIs_approved(false);
        month_salary.setIs_taken(false);

        month_salaryRepository.save(month_salary);



        }

    }
}
