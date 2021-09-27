package com.programming.techie.model;


import javax.persistence.*;

@Entity
@Table(name = "task_type")
public class Task_type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

}
