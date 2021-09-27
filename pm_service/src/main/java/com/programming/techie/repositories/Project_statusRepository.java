package com.programming.techie.repositories;

import com.programming.techie.model.Customer;
import com.programming.techie.model.Project_status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Project_statusRepository extends JpaRepository<Project_status, Long> {
}
