package com.programming.techie.service;


import com.programming.techie.dto.LeaveDto;
import com.programming.techie.model.Employee;
import com.programming.techie.model.Leave_status;
import com.programming.techie.model.Leave_type;
import com.programming.techie.model.Leaves;
import com.programming.techie.repository.EmployeeRepository;
import com.programming.techie.repository.Leave_statusRepository;
import com.programming.techie.repository.Leave_typeRepository;
import com.programming.techie.repository.LeavesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LeaveService {

    @Autowired
    LeavesRepository leavesRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    Leave_statusRepository leave_statusRepository;

    @Autowired
    Leave_typeRepository leave_typeRepository;



    public Leaves save (LeaveDto leaveDto)
    {
       Leaves leave = new Leaves();
       Optional<Employee> employee = employeeRepository.findById(leaveDto.getEmployee());
       leave.setEmployee(employee.get());


       Optional<Leave_type> type = leave_typeRepository.findById(leaveDto.getType());
       leave.setType(type.get());

      Optional<Leave_status> status = leave_statusRepository.findById((long) 2);
       leave.setStatus(status.get());
       
       leave.setStart_date(leaveDto.getStart_date());
       leave.setEnd_date(leaveDto.getEnd_date());
       leave.setSubmit_date(leaveDto.getSubmit_date());

    leavesRepository.save(leave);
    return leave;

    }


    public void accept ( Long id)
    {
        Optional<Leaves> leave = leavesRepository.findById(id);
        Optional<Leave_status> status =leave_statusRepository.findById((long) 4);
        long millis=System.currentTimeMillis();
        if (leave != null)
        {
         Leaves _leave = leave.get();
         _leave.setStatus(status.get());
         _leave.setApproval_date( new Date(millis));
         leavesRepository.save(_leave);

         }


    }

    public void reject ( Long id)
    {
        Optional<Leaves> leave = leavesRepository.findById(id);
        Optional<Leave_status> status =leave_statusRepository.findById((long) 3);

        if (leave != null)
        {
            Leaves _leave = leave.get();
            _leave.setStatus(status.get());
            leavesRepository.save(_leave);

        }


    }


    public boolean checkMax( Long id)
    {
        Optional<Leaves> leave = leavesRepository.findById(id);
        Leaves _leave = leave.get();

        Leave_type type = _leave.getType();
        int max = type.getMax();


        Employee employee = _leave.getEmployee();

        List<Leaves> leaves = leavesRepository.findByEmployeeAndType(employee,type);

        int count = leaves.size();

        if (count > max  || count == max)
        {
            return false;
        }
        else {
            return  true;
        }


    }

}
