package com.programming.techie.service;

import com.programming.techie.dto.Job_applicant_statusDto;
import com.programming.techie.dto.Job_offer_statusDto;
import com.programming.techie.model.Job_applicant_status;
import com.programming.techie.model.Job_offer_status;
import com.programming.techie.repository.Job_offer_statusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Job_offer_statusService {


    @Autowired
    Job_offer_statusRepository job_offer_statusRepository;
    public List<Job_offer_statusDto> all() {


        List<Job_offer_status> job_offer_statusList = job_offer_statusRepository.findAll();
        List<Job_offer_statusDto> list = new ArrayList();
        for (Job_offer_status job_offer_status :
                job_offer_statusList) {
            Job_offer_statusDto dto = new Job_offer_statusDto();
            dto.setId(job_offer_status.getId());
            dto.setName(job_offer_status.getName());
            list.add(dto);
        }
        return list;

    }
}
