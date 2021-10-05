package com.programming.techie.controller;


import com.programming.techie.dto.Leave_statusDto;
import com.programming.techie.model.Leave_status;
import com.programming.techie.service.Leave_statusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/leave-status")
public class Leave_statusController {


    @Autowired
    Leave_statusService leave_statusService;

    @GetMapping("/all")
    public List<Leave_statusDto> all() {
        return leave_statusService.all();

    }

}
