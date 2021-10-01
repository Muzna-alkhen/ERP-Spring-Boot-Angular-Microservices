package com.programming.techie.controller;


import com.netflix.discovery.converters.Auto;
import com.programming.techie.dto.Job_offerDto;
import com.programming.techie.service.Job_offerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/job-offer")
public class Job_offerController {

    @Autowired
    Job_offerService job_offerService;



    @PostMapping("/create")
    public String create (@RequestBody Job_offerDto job_offerDto)


    {

        job_offerService.create(job_offerDto);

        return "job offer created Successfully ! ";
    }


    @GetMapping("/open/{id}")
    public String open (@PathVariable Long id)
    {
        job_offerService.open(id);
        return "job has been opend it successfully ! ";

    }

    @GetMapping("/close/{id}")
    public String close (@PathVariable Long id)
    {
        job_offerService.close(id);
        return "job has been closed it successfully ! ";

    }

}
