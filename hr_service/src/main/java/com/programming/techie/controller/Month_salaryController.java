package com.programming.techie.controller;


import com.programming.techie.service.Month_salaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/month-salary")
public class Month_salaryController {

    @Autowired
    Month_salaryService month_salaryService;

    @GetMapping("/generate")
    public String generate()
    {


            month_salaryService.generate();
            return "Month Salaries generated successfully !";


    }


}

