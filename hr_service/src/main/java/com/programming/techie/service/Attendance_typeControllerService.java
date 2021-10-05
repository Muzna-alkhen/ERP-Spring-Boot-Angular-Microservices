package com.programming.techie.service;


import com.programming.techie.dto.Attendance_typeDto;
import com.programming.techie.model.Attendance_type;
import com.programming.techie.repository.Attendance_typeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Attendance_typeControllerService {

    @Autowired
    Attendance_typeRepository attendance_typeRepository;

    public List<Attendance_typeDto> all() {

        List<Attendance_type> attendance_typeList = attendance_typeRepository.findAll();
        List<Attendance_typeDto> list = new ArrayList();
        for (Attendance_type attendance_type :
                attendance_typeList) {
            Attendance_typeDto dto = new Attendance_typeDto();

            dto.setId(attendance_type.getId());
            dto.setName(attendance_type.getName());
            list.add(dto);

        }
        return list;
    }
}