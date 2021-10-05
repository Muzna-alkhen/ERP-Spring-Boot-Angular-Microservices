package com.programming.techie.service;


import com.programming.techie.dto.Job_offerResponseDto;
import com.programming.techie.dto.LeaveRequestDto;
import com.programming.techie.dto.LeavesResponseDto;
import com.programming.techie.model.*;
import com.programming.techie.repository.EmployeeRepository;
import com.programming.techie.repository.Leave_statusRepository;
import com.programming.techie.repository.Leave_typeRepository;
import com.programming.techie.repository.LeavesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    EmployeeService employeeService;


    public String save(LeaveRequestDto leaveRequestDto) {
        Leaves leave = new Leaves();
        Optional<Employee> employee = employeeRepository.findById(leaveRequestDto.getEmployee());
        leave.setEmployee(employee.get());


        Optional<Leave_type> type = leave_typeRepository.findById(leaveRequestDto.getType());
        leave.setType(type.get());

        Optional<Leave_status> status = leave_statusRepository.findById((long) 2);
        leave.setStatus(status.get());

        leave.setStart_date(leaveRequestDto.getStart_date());
        leave.setEnd_date(leaveRequestDto.getEnd_date());
        leave.setSubmit_date(leaveRequestDto.getSubmit_date());

        leavesRepository.save(leave);


        boolean check = checkMax(leave.getId());
        if (!check) {
            leavesRepository.delete(leave);
            return "you can't submit a leave! u have exceed the max of leaves this month";

        } else {
            boolean is_manager = employeeService.checkManager(leave.getEmployee().getId());
            if (is_manager) {
                leave.setApproval("general_manager");
                leavesRepository.save(leave);
            } else {
                leave.setApproval("hr_manager");
                leavesRepository.save(leave);
            }


            return "leave has been submitted successfully ! ";

        }


    }


    public void accept(Long id) {
        Optional<Leaves> leave = leavesRepository.findById(id);
        Optional<Leave_status> status = leave_statusRepository.findById((long) 4);
        long millis = System.currentTimeMillis();
        if (leave != null) {
            Leaves _leave = leave.get();
            _leave.setStatus(status.get());
            _leave.setApproval_date(new Date(millis));
            leavesRepository.save(_leave);


        }


    }

    public void reject(Long id) {
        Optional<Leaves> leave = leavesRepository.findById(id);
        Optional<Leave_status> status = leave_statusRepository.findById((long) 3);

        if (leave != null) {
            Leaves _leave = leave.get();
            _leave.setStatus(status.get());
            leavesRepository.save(_leave);

        }


    }


    public boolean checkMax(Long id) {
        Optional<Leaves> leave = leavesRepository.findById(id);
        Leaves _leave = leave.get();

        Leave_type type = _leave.getType();
        int max = type.getMax();


        Employee employee = _leave.getEmployee();

        List<Leaves> leaves = leavesRepository.findByEmployeeAndType(employee, type);

        int count = leaves.size();

        System.out.println("MAX  " + max + "   count  " + count);
        if ((count - 1) > max || (count - 1) == max) {
            return false;
        } else {
            return true;
        }


    }


    public void setApproval(String name, Long id) {

        Optional<Leaves> leave = leavesRepository.findById(id);
        Leaves _leave = leave.get();
        _leave.setApproval(name);
        leavesRepository.save(_leave);
    }

    public List<LeavesResponseDto> all() {


        List<Leaves> leavesList = leavesRepository.findAll();
        List<LeavesResponseDto> list = new ArrayList();
        for (Leaves leaves :
                leavesList) {
            LeavesResponseDto dto = new LeavesResponseDto();
            dto.setEmployee_name(leaves.getApproval());
            dto.setEnd_date(leaves.getEnd_date());
            dto.setId(leaves.getId());
            dto.setStart_date(leaves.getStart_date());
            dto.setSubmit_date(leaves.getSubmit_date());
            dto.setType(leaves.getType().getName());

            list.add(dto);
        }
        return list;
    }
}