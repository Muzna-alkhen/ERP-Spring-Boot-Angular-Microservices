package com.programming.techie.service;

import com.programming.techie.dto.AttendanceRequestDto;
import com.programming.techie.dto.AttendanceResponseDto;
import com.programming.techie.dto.Attendance_typeDto;
import com.programming.techie.model.Attendance;
import com.programming.techie.model.Attendance_type;
import com.programming.techie.model.Employee;
import com.programming.techie.repository.AttendanceRepository;
import com.programming.techie.repository.Attendance_typeRepository;
import com.programming.techie.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AttendanceService {


    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    Attendance_typeRepository attendance_typeRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public void create(AttendanceRequestDto attendanceRequestDto) {
        Attendance attendance = new Attendance();

        Optional<Attendance_type> type = attendance_typeRepository.findById(attendanceRequestDto.getType());
        attendance.setType(type.get());

        Optional<Employee> employee = employeeRepository.findById(attendanceRequestDto.getEmployee());
        attendance.setEmployee(employee.get());

        attendance.setDate(attendanceRequestDto.getDate());


        attendanceRepository.save(attendance);


    }

    public List<AttendanceResponseDto> all() {
        List<Attendance> attendanceList = attendanceRepository.findAll();
        List<AttendanceResponseDto> list = new ArrayList();
        for (Attendance attendance :
                attendanceList) {
            AttendanceResponseDto dto = new AttendanceResponseDto();
            dto.setDate(attendance.getDate());
            dto.setEmployee_name(attendance.getEmployee().getFirstName());
            dto.setId(attendance.getId());
            dto.setType(attendance.getType().getName());

            list.add(dto);

        }
        return list;
    }
}