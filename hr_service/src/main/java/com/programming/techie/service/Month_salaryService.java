package com.programming.techie.service;

import com.programming.techie.dto.LeavesResponseDto;
import com.programming.techie.dto.Month_salaryDto;
import com.programming.techie.model.*;
import com.programming.techie.mq.AllPayrollMsg;
import com.programming.techie.repository.AttendanceRepository;
import com.programming.techie.repository.EmployeeRepository;
import com.programming.techie.repository.LeavesRepository;
import com.programming.techie.repository.Month_salaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class Month_salaryService {

    @Autowired
    private Queue queue ;


    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    Month_salaryRepository month_salaryRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    AttendanceRepository attendanceRepository;


    @Autowired
    LeavesRepository leavesRepository;

    public AllPayrollMsg generate() {
        month_salaryRepository.deleteAll();
        List<Employee> employees = employeeRepository.findAll();
        AllPayrollMsg msg = new AllPayrollMsg();
        msg.month="01";
        msg.year="2021";
        int i =0;
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



        month_salary.setEmployee(employee);
        msg.employee_ids.add(i,employee.getId());
        msg.full_names.add(i,(employee.getFirstName())+" "+(employee.getLastName()));
        month_salary.setAmount(salary);
        msg.amounts.add(i,salary);

        month_salary.setIs_approved(false);
        month_salary.setIs_taken(false);

        month_salaryRepository.save(month_salary);

         i++;

        }
                 return msg;
    }
     public  void  send(AllPayrollMsg allPayrollMsg)
     {
         jmsTemplate.convertAndSend(queue,allPayrollMsg);
     }

    public List<Month_salaryDto> all() {


        List<Month_salary> month_salaryList = month_salaryRepository.findAll();
        List<Month_salaryDto> list = new ArrayList();
        for (Month_salary month_salary :
                month_salaryList) {
            Month_salaryDto dto = new Month_salaryDto();
            dto.setAmount(month_salary.getAmount());
            dto.setEmployee_name(month_salary.getEmployee().getFirstName());
            dto.setId(month_salary.getId());
            dto.setMonth(month_salary.getMonth());
            dto.setYear(month_salary.getYear());

            list.add(dto);
        }
        return list;

    }
}
