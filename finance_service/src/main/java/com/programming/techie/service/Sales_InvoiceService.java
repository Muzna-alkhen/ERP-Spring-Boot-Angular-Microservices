package com.programming.techie.service;

import com.programming.techie.dto.Purchase_InvoiceResponseDto;
import com.programming.techie.dto.Sales_InvoiceResponseDto;
import com.programming.techie.model.Purchase_Invoice;
import com.programming.techie.model.Sales_Invoice;
import com.programming.techie.repository.Sales_InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Sales_InvoiceService {

    @Autowired
    Sales_InvoiceRepository sales_invoiceRepository;



    public List<Sales_InvoiceResponseDto> all() {
        List<Sales_Invoice> sales_invoiceList = sales_invoiceRepository.findAll();
        List<Sales_InvoiceResponseDto> list = new ArrayList();
        for (Sales_Invoice sales_invoice :
                sales_invoiceList) {
            Sales_InvoiceResponseDto dto = new Sales_InvoiceResponseDto();
            dto.setId(sales_invoice.getId());
            dto.setIs_paid(sales_invoice.isIs_paid());
            dto.setName(sales_invoice.getName());
            dto.setPayment_date(sales_invoice.getPayment_date());
            dto.setCustomer(sales_invoice.getCustomer().getFirstName());
            dto.setTax(sales_invoice.getTax());
            dto.setTotal_price(sales_invoice.getTotal_price());
            dto.setTotal_quantity(sales_invoice.getTotal_quantity());

            list.add(dto);
        }
        return list;
    }
}
