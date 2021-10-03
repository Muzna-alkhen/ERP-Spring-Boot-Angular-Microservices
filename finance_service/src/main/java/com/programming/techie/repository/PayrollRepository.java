package com.programming.techie.repository;

import com.programming.techie.model.Customer;
import com.programming.techie.model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository  extends JpaRepository<Payroll, Long> {
}
