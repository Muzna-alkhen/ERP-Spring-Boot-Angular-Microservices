package com.programming.techie.repository;

import com.programming.techie.model.Approval_status;
import com.programming.techie.model.Offer_approval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Approval_statusRepository  extends JpaRepository<Approval_status, Long> {
}
