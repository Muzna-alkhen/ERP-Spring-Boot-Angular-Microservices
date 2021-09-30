package com.programming.techie.repository;

import com.programming.techie.model.Employee;
import com.programming.techie.model.Leave_type;
import com.programming.techie.model.Leaves;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeavesRepository extends JpaRepository<Leaves, Long> {

List<Leaves> findByEmployeeAndType(Employee employee , Leave_type type);
}
