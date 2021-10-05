package com.programming.techie.service;

import com.programming.techie.dto.PayrollResponseDto;
import com.programming.techie.dto.Purchase_InvoiceResponseDto;
import com.programming.techie.model.Payroll;
import com.programming.techie.model.Purchase_Invoice;
import com.programming.techie.repository.Purchase_InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Purchase_InvoiceService {


    @Autowired
    Purchase_InvoiceRepository purchase_invoiceRepository;


    public List<Purchase_InvoiceResponseDto> all() {


        List<Purchase_Invoice> purchase_invoiceList = purchase_invoiceRepository.findAll();
        List<Purchase_InvoiceResponseDto> list = new ArrayList();
        for (Purchase_Invoice purchase_invoice :
                purchase_invoiceList) {
            Purchase_InvoiceResponseDto dto = new Purchase_InvoiceResponseDto();
            dto.setId(purchase_invoice.getId());
            dto.setIs_paid(purchase_invoice.isIs_paid());
            dto.setName(purchase_invoice.getName());
            dto.setPayment_date(purchase_invoice.getPayment_date());
            dto.setSupplier(purchase_invoice.getSupplier().getFirstName());
            dto.setTax(purchase_invoice.getTax());
            dto.setTotal_price(purchase_invoice.getTotal_price());
            dto.setTotal_quantity(purchase_invoice.getTotal_quantity());

            list.add(dto);

        }
        return  list;

    }
}
