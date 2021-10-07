package com.programming.techie.controller;


import com.programming.techie.dto.Approval_StatusDto;
import com.programming.techie.service.Approval_StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/approval-status")
public class Approval_StatusController {

    @Autowired
    Approval_StatusService approval_statusService;


    @GetMapping("/all")
    public List<Approval_StatusDto> all() {
        return approval_statusService.all();

    }
}