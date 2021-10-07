package com.programming.techie.controller;


import com.programming.techie.dto.AttendanceRequestDto;
import com.programming.techie.dto.AttendanceResponseDto;
import com.programming.techie.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    @PostMapping ("/create")
    public String create (@RequestBody AttendanceRequestDto attendanceRequestDto)
    {
        attendanceService.create(attendanceRequestDto);
        return "attendance created successfully !";
    }

    @GetMapping("/all")
    public List<AttendanceResponseDto> all() {
        return attendanceService.all();

    }


}
