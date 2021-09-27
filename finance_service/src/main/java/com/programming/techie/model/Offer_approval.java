package com.programming.techie.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "offer_approval")
public class Offer_approval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "submit_date")
    private Date submit_date;

    @Column(name = "approval_date")
    private Date approval_date;

    @Column(name = "cost")
    private float cost;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name="status")
    private Approval_status status;

    @ManyToOne
    @JoinColumn(name="transaction")
    private Transaction_in transaction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSubmit_date() {
        return submit_date;
    }

    public void setSubmit_date(Date submit_date) {
        this.submit_date = submit_date;
    }

    public Date getApproval_date() {
        return approval_date;
    }

    public void setApproval_date(Date approval_date) {
        this.approval_date = approval_date;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Approval_status getStatus() {
        return status;
    }

    public void setStatus(Approval_status status) {
        this.status = status;
    }

    public Transaction_in getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction_in transaction) {
        this.transaction = transaction;
    }
}
