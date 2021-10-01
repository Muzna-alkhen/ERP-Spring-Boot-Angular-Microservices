package com.programming.techie.repository;

import com.programming.techie.model.Purchase_Invoice;
import com.programming.techie.model.Transaction_out;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Purchase_InvoiceRepository  extends JpaRepository<Purchase_Invoice, Long> {
}
