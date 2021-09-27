package com.programming.techie.repositories;

import com.programming.techie.model.Customer;
import com.programming.techie.model.Quotation_status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Quotation_statusRepository extends JpaRepository<Quotation_status, Long> {
}
