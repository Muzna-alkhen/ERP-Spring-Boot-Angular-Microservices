package com.programming.techie.service;


import com.programming.techie.dto.Job_applicantResponseDto;
import com.programming.techie.dto.Job_applicant_statusDto;
import com.programming.techie.model.Job_applicant;
import com.programming.techie.model.Job_applicant_status;
import com.programming.techie.repository.Job_applicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Job_applicantService {

    @Autowired
    Job_applicantRepository job_applicantRepository;

    public List<Job_applicantResponseDto> all() {

        List<Job_applicant> job_applicantList = job_applicantRepository.findAll();
        List<Job_applicantResponseDto> list = new ArrayList();
        for (Job_applicant job_applicant :
                job_applicantList) {
            Job_applicantResponseDto dto = new Job_applicantResponseDto();

            dto.setApplicant_date(job_applicant.getApplicant_date());
            dto.setCv_path(job_applicant.getCv_path());
            dto.setEmail(job_applicant.getEmail());
            dto.setFirstName(job_applicant.getFirstName());
            dto.setId(job_applicant.getId());
            dto.setIs_on_boarding(job_applicant.getIs_on_boarding());
            dto.setStatus(job_applicant.getCv_path());
            dto.setFirstName(job_applicant.getFirstName());
            list.add(dto);
        }
        return list;

    }
}
