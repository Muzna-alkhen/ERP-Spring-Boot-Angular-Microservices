package com.programming.techie.repository;

import com.programming.techie.model.Customer;
import com.programming.techie.model.Transaction_out;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer, Long> {
}
