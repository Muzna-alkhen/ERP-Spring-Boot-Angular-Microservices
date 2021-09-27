package com.programming.techie.model;


import javax.persistence.*;

@Entity
@Table(name = "task_assigned_status")
public class Task_assigned_status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

}

