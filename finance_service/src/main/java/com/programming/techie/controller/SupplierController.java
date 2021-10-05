package com.programming.techie.controller;


import com.programming.techie.dto.Purchase_InvoiceResponseDto;
import com.programming.techie.dto.SupplierResponseDto;
import com.programming.techie.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/supplier")
public class SupplierController {


    @Autowired
    SupplierService supplierService;

    @GetMapping("/all")
    public List<SupplierResponseDto> all() {
        return supplierService.all();

    }

}
