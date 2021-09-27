package com.programming.techie.model;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "transaction_out")
public class Transaction_out {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date date;

    @Column(name = "amount")
    private float amount;


    @OneToMany(mappedBy="transaction")
    private List<Salary_approval> salary_approvalList;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public List<Salary_approval> getSalary_approvalList() {
        return salary_approvalList;
    }

    public void setSalary_approvalList(List<Salary_approval> salary_approvalList) {
        this.salary_approvalList = salary_approvalList;
    }
}
