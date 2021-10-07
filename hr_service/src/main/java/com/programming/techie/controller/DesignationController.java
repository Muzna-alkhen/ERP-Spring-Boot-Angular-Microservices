package com.programming.techie.controller;


import com.programming.techie.dto.DesignationDto;
import com.programming.techie.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/designation")
public class DesignationController {


    @Autowired
    DesignationService designationService;

    @GetMapping("/all")
    public List<DesignationDto> all() {
        return designationService.all();

    }
}
