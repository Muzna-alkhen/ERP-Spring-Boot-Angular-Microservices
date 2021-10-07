package com.programming.techie.controller;


import com.programming.techie.dto.Journal_EntryDto;
import com.programming.techie.dto.PayrollRequestDto;
import com.programming.techie.dto.PayrollResponseDto;
import com.programming.techie.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payroll")
public class PayrollController {

    @Autowired
    PayrollService payrollService;

    @PostMapping("/request")
    public String request (@RequestBody PayrollRequestDto payrollDto)
    {
        payrollService.request(payrollDto);
        return "Request has been send to HR department!";


    }


    @GetMapping("/all")
    public List<PayrollResponseDto> all() {
        return payrollService.all();

    }


}
