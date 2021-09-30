package com.programming.techie.repository;

import com.programming.techie.model.Offer_approval;
import com.programming.techie.model.Transaction_in;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Transaction_inRepository  extends JpaRepository<Transaction_in, Long> {
}
