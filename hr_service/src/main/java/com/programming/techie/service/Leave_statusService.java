package com.programming.techie.service;


import com.programming.techie.dto.Job_offer_statusDto;
import com.programming.techie.dto.Leave_statusDto;
import com.programming.techie.model.Job_offer_status;
import com.programming.techie.model.Leave_status;
import com.programming.techie.repository.Leave_statusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Leave_statusService {

    @Autowired
    Leave_statusRepository leave_statusRepository;

    public List<Leave_statusDto> all() {

        List<Leave_status> leave_statusList = leave_statusRepository.findAll();
        List<Leave_statusDto> list = new ArrayList();
        for (Leave_status leave_status :
                leave_statusList) {
            Leave_statusDto dto = new Leave_statusDto();
            dto.setId(leave_status.getId());
            dto.setName(leave_status.getName());
            list.add(dto);
        }
        return list;


    }
}
