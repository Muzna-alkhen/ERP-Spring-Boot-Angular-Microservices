package com.programming.techie.controller;


import com.programming.techie.dto.Financial_approvalResponseDto;
import com.programming.techie.service.Financial_approvalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/financial-approval")
public class Financial_approvalController {


    @Autowired
    Financial_approvalService financial_approvalService;




    @GetMapping("/all")
    public List<Financial_approvalResponseDto> all() {
        return financial_approvalService.all();

    }
}
