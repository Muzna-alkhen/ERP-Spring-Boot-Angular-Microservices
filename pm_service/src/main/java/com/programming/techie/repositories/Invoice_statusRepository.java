package com.programming.techie.repositories;

import com.programming.techie.model.Customer;
import com.programming.techie.model.Invoice;
import com.programming.techie.model.Invoice_status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Invoice_statusRepository extends JpaRepository<Invoice_status, Long> {
}
