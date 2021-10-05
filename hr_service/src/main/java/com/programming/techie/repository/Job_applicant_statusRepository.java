package com.programming.techie.repository;

import com.programming.techie.model.Grade;
import com.programming.techie.model.Job_applicant_status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Job_applicant_statusRepository  extends JpaRepository<Job_applicant_status, Long> {
}
