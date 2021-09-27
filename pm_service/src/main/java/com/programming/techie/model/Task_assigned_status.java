package com.programming.techie.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "task_assigned_status")
public class Task_assigned_status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="status")
    private List<Task_assigned> task_assignedList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task_assigned> getTask_assignedList() {
        return task_assignedList;
    }

    public void setTask_assignedList(List<Task_assigned> task_assignedList) {
        this.task_assignedList = task_assignedList;
    }
}

