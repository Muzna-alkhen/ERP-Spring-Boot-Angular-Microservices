package com.programming.techie.service;


import com.programming.techie.dto.Approval_StatusDto;
import com.programming.techie.dto.Financial_approvalResponseDto;
import com.programming.techie.model.Approval_status;
import com.programming.techie.model.Financial_approval;
import com.programming.techie.repository.Financial_approvalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Financial_approvalService {

    @Autowired
    Financial_approvalRepository financial_approvalRepository;

    public List<Financial_approvalResponseDto> all() {

        List<Financial_approval> financial_approvalList =financial_approvalRepository.findAll();
        List<Financial_approvalResponseDto> list = new ArrayList();
        for (Financial_approval financial_approval :
                financial_approvalList) {
            Financial_approvalResponseDto dto = new Financial_approvalResponseDto();
            dto.setApproval_date(financial_approval.getApproval_date());
            dto.setCost(financial_approval.getCost());
            dto.setId(financial_approval.getId());
            dto.setStatus(financial_approval.getStatus().getName());

            list.add(dto);


        }
      return list;
    }
}

