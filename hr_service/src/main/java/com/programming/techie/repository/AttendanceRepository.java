package com.programming.techie.repository;

import com.programming.techie.model.Attendance;
import com.programming.techie.model.Employee;
import com.programming.techie.model.Leave_type;
import com.programming.techie.model.Leaves;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByEmployee(Employee employee);







}
