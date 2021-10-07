package com.programming.techie.controller;


import com.programming.techie.dto.Journal_EntryDto;
import com.programming.techie.dto.Purchase_InvoiceResponseDto;
import com.programming.techie.service.Purchase_InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/purchase-invoice")
public class Purchase_InvoiceController {


    @Autowired
    Purchase_InvoiceService purchase_invoiceService;



    @GetMapping("/all")
    public List<Purchase_InvoiceResponseDto> all() {
        return purchase_invoiceService.all();

    }

}
