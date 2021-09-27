package com.programming.techie.repository;

import com.programming.techie.model.Leave_type;
import com.programming.techie.model.Leaves;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeavesRepository extends JpaRepository<Leaves, Long> {
}
