package com.programming.techie.controller;


import com.programming.techie.dto.Job_applicantResponseDto;
import com.programming.techie.model.Job_applicant;
import com.programming.techie.service.Job_applicantService;
import com.programming.techie.service.Job_applicant_statusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/job-applicant")
public class Job_applicantController {

    @Autowired
    Job_applicantService job_applicantService;

    @GetMapping("/all")
    public List<Job_applicantResponseDto> all() {
        return job_applicantService.all();

    }
}
