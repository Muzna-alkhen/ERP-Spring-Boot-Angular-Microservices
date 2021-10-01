package com.programming.techie.repository;

import com.programming.techie.model.Supplier;
import com.programming.techie.model.Transaction_out;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository  extends JpaRepository<Supplier, Long> {
}
