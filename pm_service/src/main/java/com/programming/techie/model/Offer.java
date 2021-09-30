package com.programming.techie.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "offer")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name")
    private String name;


    @Column(name = "submit_date")
    private Date submit_date;


    @Column(name = "delivery_date")
    private Date delivery_date;


    @Column(name = "total_cost")
    private Float total_cost;

    @Column(name = "description")
    private String description;

    @Column(name = "financial_approval")
    private Long financial_approval;

    @ManyToOne
    @JoinColumn(name="customer")
    private Customer customer;


    @ManyToOne
    @JoinColumn(name="project")
    private Project project;

    @ManyToOne
    @JoinColumn(name="status")
    private Offer_status status;

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

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public Float getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(Float total_cost) {
        this.total_cost = total_cost;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Offer_status getStatus() {
        return status;
    }

    public void setStatus(Offer_status status) {
        this.status = status;
    }
}
