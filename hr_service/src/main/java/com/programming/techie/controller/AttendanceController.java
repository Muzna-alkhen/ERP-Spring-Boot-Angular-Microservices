package com.programming.techie.controller;


import com.programming.techie.dto.AttendanceDto;
import com.programming.techie.model.Attendance;
import com.programming.techie.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    @PostMapping ("/create")
    public String create (@RequestBody AttendanceDto attendanceDto)
    {
        attendanceService.create(attendanceDto);
        return "attendance created successfully !";
    }

}
