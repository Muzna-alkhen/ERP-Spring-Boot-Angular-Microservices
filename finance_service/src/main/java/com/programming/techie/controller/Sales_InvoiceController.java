package com.programming.techie.controller;


import com.programming.techie.dto.Purchase_InvoiceResponseDto;
import com.programming.techie.dto.Sales_InvoiceResponseDto;
import com.programming.techie.model.Sales_Invoice;
import com.programming.techie.service.Sales_InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/sales-invoice")
public class Sales_InvoiceController {

    @Autowired
    Sales_InvoiceService sales_invoiceService;


    @GetMapping("/all")
    public List<Sales_InvoiceResponseDto> all() {
        return sales_invoiceService.all();

    }
}
