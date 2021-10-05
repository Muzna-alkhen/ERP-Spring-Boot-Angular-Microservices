package com.programming.techie.service;


import com.programming.techie.dto.AttendanceResponseDto;
import com.programming.techie.dto.DepartmentDto;
import com.programming.techie.model.Attendance;
import com.programming.techie.model.Department;
import com.programming.techie.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;
    public List<DepartmentDto> all() {

        List<Department> departmentList = departmentRepository.findAll();
        List<DepartmentDto> list = new ArrayList();
        for (Department department :
                departmentList) {
            DepartmentDto dto = new DepartmentDto();

            dto.setId(department.getId());
            dto.setName(department.getName());
            list.add(dto);
        }
        return list;
    }
}
