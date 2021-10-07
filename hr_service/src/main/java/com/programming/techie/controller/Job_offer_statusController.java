package com.programming.techie.controller;


import com.programming.techie.dto.Job_offer_statusDto;
import com.programming.techie.service.Job_offer_statusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/job-offer-status")
public class Job_offer_statusController {


    @Autowired
    Job_offer_statusService job_offer_statusService;

    @GetMapping("/all")
    public List<Job_offer_statusDto> all() {
        return job_offer_statusService.all();

    }
}
