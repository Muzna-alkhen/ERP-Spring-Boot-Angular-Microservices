package com.programming.techie.controller;


import com.programming.techie.dto.EmployeeDto;
import com.programming.techie.repository.EmployeeRepository;
import com.programming.techie.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/employees")
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;



    @PostMapping ("/create")

    public  String create(@RequestBody  EmployeeDto employeeDto)

    {
        employeeService.create(employeeDto);
        return "Employee created successfully !";


    }


    @GetMapping("/checkManager/{id}")
    public boolean checkManager (@PathVariable("id") Long id )
    {
            return employeeService.checkManager(id);

    }



}
