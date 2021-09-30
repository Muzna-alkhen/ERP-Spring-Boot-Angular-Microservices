package com.programming.techie.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task_assigned")
public class Task_assigned {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "employee")
    private Long employee;


    @Column(name = "description")
    private String description;



    @Column(name = "assigned_date")
    private Date assigned_date ;


    @Column(name = "start_date")
    private Date start_date;


    @Column(name = "end_date")
    private Date end_date;


    @Column(name = "actual_start_date")
    private Date actual_start_date;


    @Column(name = "actual_end_date")
    private Date actual_end_date;

    @ManyToOne
    @JoinColumn(name="project")
    private Project project ;


    @ManyToOne
    @JoinColumn(name="status")
    private Task_assigned_status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployee() {
        return employee;
    }

    public void setEmployee(Long employee) {
        this.employee = employee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAssigned_date() {
        return assigned_date;
    }

    public void setAssigned_date(Date assigned_date) {
        this.assigned_date = assigned_date;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getActual_start_date() {
        return actual_start_date;
    }

    public void setActual_start_date(Date actual_start_date) {
        this.actual_start_date = actual_start_date;
    }

    public Date getActual_end_date() {
        return actual_end_date;
    }

    public void setActual_end_date(Date actual_end_date) {
        this.actual_end_date = actual_end_date;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Task_assigned_status getStatus() {
        return status;
    }

    public void setStatus(Task_assigned_status status) {
        this.status = status;
    }
}
