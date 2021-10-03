package com.programming.techie.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payroll")
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "employee_id")
    private Long employee_id;


    @Column(name = "month")
    private String month;

    @Column(name = "year")
    private String year;

    @Column(name = "amount")
    private int amount;

    @Column(name = "is_taken")
    private boolean is_taken;


}
