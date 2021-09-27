package com.programming.techie.model;


import com.programming.techie.model.Attendance_type;
import com.programming.techie.model.Employee;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "attendance")
public class Attendance {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="type" )
    private Attendance_type type;

    @ManyToOne
    @JoinColumn(name="employee" )
    private Employee employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Attendance_type getType() {
        return type;
    }

    public void setType(Attendance_type type) {
        this.type = type;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
