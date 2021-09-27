package com.programming.techie.model;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "approval_status")
public class Approval_status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy="status")
    private List<Salary_approval> salary_approvalList;

    @OneToMany(mappedBy="status")
    private List<Offer_approval> offer_approvalList;

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

    public List<Salary_approval> getSalary_approvalList() {
        return salary_approvalList;
    }

    public void setSalary_approvalList(List<Salary_approval> salary_approvalList) {
        this.salary_approvalList = salary_approvalList;
    }

    public List<Offer_approval> getOffer_approvalList() {
        return offer_approvalList;
    }

    public void setOffer_approvalList(List<Offer_approval> offer_approvalList) {
        this.offer_approvalList = offer_approvalList;
    }
}