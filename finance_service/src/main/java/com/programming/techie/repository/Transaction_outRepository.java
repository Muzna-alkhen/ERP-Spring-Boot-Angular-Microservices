package com.programming.techie.repository;

import com.programming.techie.model.Transaction_in;
import com.programming.techie.model.Transaction_out;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Transaction_outRepository  extends JpaRepository<Transaction_out, Long> {
}
