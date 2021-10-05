package com.programming.techie.service;

import com.programming.techie.dto.CustomerDto;
import com.programming.techie.dto.CustomerResponseDto;
import com.programming.techie.model.Customer;
import com.programming.techie.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public void save(CustomerDto customerDto) {

        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setMiddleName(customerDto.getMiddleName());
        customer.setLastName(customerDto.getLastName());
        customer.setAddress(customerDto.getAddress());
        customer.setCompany(customerDto.getCompany());
        customer.setContact(customerDto.getContact());
        customer.setDateOfBirth(customerDto.getDateOfBirth());
        customer.setEmail(customerDto.getEmail());

        customerRepository.save(customer);


    }

    public CustomerDto get(Long id) {

        Optional<Customer> customer = customerRepository.findById(id);
        CustomerDto dto = new CustomerDto();
        dto.setAddress(customer.get().getAddress());
        dto.setCompany(customer.get().getCompany());
        dto.setContact(customer.get().getContact());
        dto.setDateOfBirth(customer.get().getDateOfBirth());
        dto.setEmail(customer.get().getEmail());
        dto.setFirstName(customer.get().getFirstName());
        dto.setMiddleName(customer.get().getMiddleName());
        dto.setLastName(customer.get().getLastName());

        return dto;
    }

    public List<CustomerResponseDto> all() {

        List<Customer> customerList = customerRepository.findAll();
        List<CustomerResponseDto> list = new ArrayList();
        for (Customer customer :
                customerList) {
            CustomerResponseDto dto = new CustomerResponseDto();
            dto.setAddress(customer.getAddress());
            dto.setCompany(customer.getCompany());
            dto.setContact(customer.getContact());
            dto.setEmail(customer.getEmail());
            dto.setFirstName(customer.getFirstName());
            dto.setLastName(customer.getLastName());

            list.add(dto);
        }
        return list;
    }
}