package com.programming.techie.controller;


import com.programming.techie.dto.CustomerDto;
import com.programming.techie.dto.CustomerResponseDto;
import com.programming.techie.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @PostMapping("/create")

    public String create(@RequestBody CustomerDto customerDto)


    {
        customerService.save(customerDto);
        return ("Customer has been created successfully!");

    }


    @GetMapping("/{id}")
    public CustomerDto get(@PathVariable Long id)
    {
        return customerService.get(id);

    }


    @GetMapping("/all")
    public List<CustomerResponseDto> all() {
        return customerService.all();


    }



    }
