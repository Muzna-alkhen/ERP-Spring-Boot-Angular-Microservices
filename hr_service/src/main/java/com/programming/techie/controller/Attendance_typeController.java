package com.programming.techie.controller;


import com.programming.techie.dto.Attendance_typeDto;
import com.programming.techie.service.Attendance_typeControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/attendance-type")
public class Attendance_typeController {

    @Autowired
    Attendance_typeControllerService attendance_typeControllerService;


    @GetMapping("/all")
    public List<Attendance_typeDto> all() {
        return attendance_typeControllerService.all();

    }

}
