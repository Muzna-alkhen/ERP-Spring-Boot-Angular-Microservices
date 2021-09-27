package com.programming.techie.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "actual_start_date")
    private Date actual_start_date;

    @Column(name = "actual_end_date")
    private Date actual_end_date;


    @OneToMany(mappedBy="project")
    private List<Offer> offerList;


    @ManyToOne
    @JoinColumn(name="template")
    private Project_template template;

    @OneToMany(mappedBy="project")
    private List<Invoice> invoiceList ;

    @ManyToOne
    @JoinColumn(name="status")
    private Project_status status;


    @OneToMany(mappedBy="project")
    private List<Task_assigned> task_assignedList ;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<Offer> getOfferList() {
        return offerList;
    }

    public void setOfferList(List<Offer> offerList) {
        this.offerList = offerList;
    }

    public Project_template getTemplate() {
        return template;
    }

    public void setTemplate(Project_template template) {
        this.template = template;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public Project_status getStatus() {
        return status;
    }

    public void setStatus(Project_status status) {
        this.status = status;
    }

    public List<Task_assigned> getTask_assignedList() {
        return task_assignedList;
    }

    public void setTask_assignedList(List<Task_assigned> task_assignedList) {
        this.task_assignedList = task_assignedList;
    }
}
