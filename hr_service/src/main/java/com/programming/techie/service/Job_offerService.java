package com.programming.techie.service;

import com.programming.techie.dto.Job_offerRequestDto;
import com.programming.techie.model.Job_offer;
import com.programming.techie.model.Job_offer_status;
import com.programming.techie.repository.Job_offerRepository;
import com.programming.techie.repository.Job_offer_statusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class Job_offerService {


    @Autowired
    Job_offerRepository job_offerRepository;

    @Autowired
    Job_offer_statusRepository job_offer_statusRepository;



    public void create(Job_offerRequestDto job_offerRequestDto) {
        Job_offer job_offer = new Job_offer();
        job_offer.setName(job_offerRequestDto.getName());
        job_offer.setDescription(job_offerRequestDto.getDescription());
        job_offer.setNumber(job_offerRequestDto.getNumber());
        job_offer.setQualifications(job_offerRequestDto.getQualifications());
        job_offer.setSubmit_date(job_offerRequestDto.getSubmit_date());

        Optional<Job_offer_status> status = job_offer_statusRepository.findById((long)1);
        job_offer.setStatus(status.get());

        job_offerRepository.save(job_offer);

    }

    public void open(Long id) {

        Optional<Job_offer> job_offer = job_offerRepository.findById(id);

        Job_offer _job_offer = job_offer.get();

        Optional<Job_offer_status> status = job_offer_statusRepository.findById((long)2);

        _job_offer.setStatus(status.get());

        job_offerRepository.save(_job_offer);
    }


    public void close(Long id) {

        Optional<Job_offer> job_offer = job_offerRepository.findById(id);

        Job_offer _job_offer = job_offer.get();

        Optional<Job_offer_status> status = job_offer_statusRepository.findById((long)3);

        _job_offer.setStatus(status.get());

        job_offerRepository.save(_job_offer);
    }
}
