package com.programming.techie.service;


import com.programming.techie.dto.Leave_statusDto;
import com.programming.techie.dto.Leave_typeDto;
import com.programming.techie.model.Leave_status;
import com.programming.techie.model.Leave_type;
import com.programming.techie.repository.Leave_typeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Leave_typeService {
    @Autowired
    Leave_typeRepository leave_typeRepository;

    public List<Leave_typeDto> all() {
        List<Leave_type> leave_typeList = leave_typeRepository.findAll();
        List<Leave_typeDto> list = new ArrayList();
        for (Leave_type leave_type :
                leave_typeList) {
            Leave_typeDto dto = new Leave_typeDto();
            dto.setId(leave_type.getId());
            dto.setName(leave_type.getName());
            list.add(dto);
        }
        return list;

    }
}
