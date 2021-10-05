package com.programming.techie.controller;


import com.programming.techie.dto.Job_applicant_statusDto;
import com.programming.techie.service.Job_applicant_statusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/job-applicant-status")
public class Job_applicant_statusController {


    @Autowired
    Job_applicant_statusService job_applicant_statusService;


    @GetMapping("/all")
    public List<Job_applicant_statusDto> all() {
        return job_applicant_statusService.all();

    }
}
