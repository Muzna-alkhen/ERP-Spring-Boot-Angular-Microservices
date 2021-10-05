package com.programming.techie.controller;


import com.programming.techie.dto.GradeDto;
import com.programming.techie.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/grade")
public class GradeController {


    @Autowired
    GradeService gradeService;

    @GetMapping("/all")
    public List<GradeDto> all() {
        return gradeService.all();

    }
}
