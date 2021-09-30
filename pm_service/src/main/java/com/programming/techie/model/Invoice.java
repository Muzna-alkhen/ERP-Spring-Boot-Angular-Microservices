package com.programming.techie.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "invoice")
public class Invoice {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "submit_date")
    private Date submit_date;

    @Column(name = "actual_total_cost")
    private Float actual_total_cost;

    @Column(name = "description")
    private String description;

    @Column(name = "financial_transaction")
    private Long financial_approval;


    @ManyToOne
    @JoinColumn(name="status")
    private Invoice_status status;


    @ManyToOne
    @JoinColumn(name="project")
    private Project project;

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

    public Date getSubmit_date() {
        return submit_date;
    }

    public void setSubmit_date(Date submit_date) {
        this.submit_date = submit_date;
    }

    public Float getActual_total_cost() {
        return actual_total_cost;
    }

    public void setActual_total_cost(Float actual_total_cost) {
        this.actual_total_cost = actual_total_cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getFinancial_approval() {
        return financial_approval;
    }

    public void setFinancial_approval(Long financial_approval) {
        this.financial_approval = financial_approval;
    }

    public Invoice_status getStatus() {
        return status;
    }

    public void setStatus(Invoice_status status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
