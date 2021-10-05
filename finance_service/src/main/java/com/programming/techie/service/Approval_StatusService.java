package com.programming.techie.service;

import com.programming.techie.dto.Approval_StatusDto;
import com.programming.techie.model.Approval_status;
import com.programming.techie.repository.Approval_statusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Approval_StatusService {


    @Autowired
    Approval_statusRepository approval_statusRepository;

    public List<Approval_StatusDto> all() {


        List<Approval_status> approval_statusList =approval_statusRepository.findAll();
        List<Approval_StatusDto> list = new ArrayList();
        for (Approval_status approval_status:
                approval_statusList) {
            Approval_StatusDto dto = new Approval_StatusDto();
            dto.setId(approval_status.getId());
            dto.setName(approval_status.getName());
          list.add(dto);
        }



        return list;
    }
}
