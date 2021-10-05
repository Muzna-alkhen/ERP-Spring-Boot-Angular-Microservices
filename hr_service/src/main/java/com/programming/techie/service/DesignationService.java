package com.programming.techie.service;


import com.programming.techie.dto.DepartmentDto;
import com.programming.techie.dto.DesignationDto;
import com.programming.techie.model.Department;
import com.programming.techie.model.Designation;
import com.programming.techie.repository.DepartmentRepository;
import com.programming.techie.repository.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DesignationService {

    @Autowired
    DesignationRepository designationRepository;
    public List<DesignationDto> all() {

        List<Designation> designationList = designationRepository.findAll();
        List<DesignationDto> list = new ArrayList();
        for (Designation designation :
                designationList) {
            DesignationDto dto = new DesignationDto();

            dto.setId(designation.getId());
            dto.setName(designation.getName());
            list.add(dto);
        }
        return list;
    }
}
