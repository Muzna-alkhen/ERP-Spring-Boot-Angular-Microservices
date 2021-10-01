package com.programming.techie.repository;

import com.programming.techie.model.Sales_Invoice;
import com.programming.techie.model.Transaction_out;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Sales_InvoiceRepository  extends JpaRepository<Sales_Invoice, Long> {
}
