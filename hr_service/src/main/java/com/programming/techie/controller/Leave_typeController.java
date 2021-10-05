package com.programming.techie.controller;


import com.programming.techie.dto.Leave_typeDto;
import com.programming.techie.model.Leave_type;
import com.programming.techie.service.Leave_typeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/leave-type")
public class Leave_typeController {

    @Autowired
    Leave_typeService leave_typeService;


    @GetMapping("/all")
    public List<Leave_typeDto> all() {
        return leave_typeService.all();

    }
}
