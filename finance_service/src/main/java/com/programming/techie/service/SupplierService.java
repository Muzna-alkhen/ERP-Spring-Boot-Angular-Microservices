package com.programming.techie.service;

import com.programming.techie.dto.CustomerResponseDto;
import com.programming.techie.dto.SupplierResponseDto;
import com.programming.techie.model.Customer;
import com.programming.techie.model.Supplier;
import com.programming.techie.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierService {


    @Autowired
    SupplierRepository supplierRepository;


    public List<SupplierResponseDto> all() {


        List<Supplier> supplierList = supplierRepository.findAll();
        List<SupplierResponseDto> list = new ArrayList();
        for (Supplier supplier :
                supplierList) {
            SupplierResponseDto dto = new SupplierResponseDto();
            dto.setAddress(supplier.getAddress());
            dto.setCompany(supplier.getCompany());
            dto.setContact(supplier.getContact());
            dto.setEmail(supplier.getEmail());
            dto.setFirstName(supplier.getFirstName());
            dto.setLastName(supplier.getLastName());

            list.add(dto);
        }
        return list;
    }



}
