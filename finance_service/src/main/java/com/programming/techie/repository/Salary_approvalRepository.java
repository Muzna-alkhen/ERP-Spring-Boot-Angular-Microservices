package com.programming.techie.repository;

import com.programming.techie.model.Offer_approval;
import com.programming.techie.model.Salary_approval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Salary_approvalRepository  extends JpaRepository<Salary_approval, Long> {
}
