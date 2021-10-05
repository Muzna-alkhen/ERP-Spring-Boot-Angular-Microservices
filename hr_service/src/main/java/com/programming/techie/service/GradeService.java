package com.programming.techie.service;


import com.programming.techie.dto.DesignationDto;
import com.programming.techie.dto.GradeDto;
import com.programming.techie.model.Designation;
import com.programming.techie.model.Grade;
import com.programming.techie.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradeService {

     @Autowired
    GradeRepository gradeRepository;

    public List<GradeDto> all() {

        List<Grade> gradeList = gradeRepository.findAll();
        List<GradeDto> list = new ArrayList();
        for (Grade grade :
                gradeList) {
            GradeDto dto = new GradeDto();
            dto.setId(grade.getId());
            dto.setName(grade.getName());
            list.add(dto);
        }
        return list;
    }
}
