package com.programming.techie.controller;


import com.programming.techie.dto.Job_offerRequestDto;
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
    public String create (@RequestBody Job_offerRequestDto job_offerRequestDto)


    {

        job_offerService.create(job_offerRequestDto);

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
