package com.programming.techie.service;

import com.programming.techie.dto.AttendanceDto;
import com.programming.techie.model.Attendance;
import com.programming.techie.model.Attendance_type;
import com.programming.techie.model.Employee;
import com.programming.techie.repository.AttendanceRepository;
import com.programming.techie.repository.Attendance_typeRepository;
import com.programming.techie.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AttendanceService {


    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    Attendance_typeRepository attendance_typeRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public void create(AttendanceDto attendanceDto)
    {
        Attendance attendance = new Attendance();

        Optional<Attendance_type> type = attendance_typeRepository.findById(attendanceDto.getType()) ;
        attendance.setType(type.get());

        Optional<Employee> employee = employeeRepository.findById(attendanceDto.getEmployee());
        attendance.setEmployee(employee.get());

        attendance.setDate(attendanceDto.getDate());

        attendanceRepository.save(attendance);
    }
}
