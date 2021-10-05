package com.programming.techie.service;


import com.programming.techie.dto.GradeDto;
import com.programming.techie.dto.Job_applicant_statusDto;
import com.programming.techie.model.Grade;
import com.programming.techie.model.Job_applicant_status;
import com.programming.techie.repository.Job_applicant_statusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Job_applicant_statusService {

    @Autowired
    Job_applicant_statusRepository job_applicant_statusRepository;

    public List<Job_applicant_statusDto> all() {
        List<Job_applicant_status> job_applicant_statusList = job_applicant_statusRepository.findAll();
        List<Job_applicant_statusDto> list = new ArrayList();
        for (Job_applicant_status job_applicant_status :
                job_applicant_statusList) {
            Job_applicant_statusDto dto = new Job_applicant_statusDto();
            dto.setId(job_applicant_status.getId());
            dto.setName(job_applicant_status.getName());
            list.add(dto);
        }
        return list;


    }
}
