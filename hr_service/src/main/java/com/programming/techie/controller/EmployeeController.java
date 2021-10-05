package com.programming.techie.controller;


import com.programming.techie.dto.EmployeeFullResponseDto;
import com.programming.techie.dto.EmployeeRequestDto;
import com.programming.techie.dto.EmployeeResponseDto;
import com.programming.techie.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/employees")
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;



    @GetMapping("get/{username}")
    public EmployeeFullResponseDto get(@PathVariable String username)
    {
        return employeeService.get(username);

    }


    @GetMapping("/all")
    public List<EmployeeResponseDto> getAll()
    {

    return employeeService.getAll();

    }


    @PostMapping ("/create")

    public  String create(@RequestBody EmployeeRequestDto employeeRequestDto)

    {
        employeeService.create(employeeRequestDto);
        return "Employee created successfully !";


    }


    @GetMapping("/checkManager/{id}")
    public boolean checkManager (@PathVariable("id") Long id )
    {
            return employeeService.checkManager(id);

    }



}
