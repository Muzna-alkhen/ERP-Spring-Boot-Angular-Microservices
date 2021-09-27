package com.programming.techie.model;


import javax.persistence.*;

@Entity
@Table(name = "month_salary")
public class Month_salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year")
    private String year;

    @Column(name = "month")
    private String month;

    @Column(name = "is_approved")
    private Boolean is_approved;


    @Column(name = "amount")
    private float amount;

    @Column(name = "financial_approval")
    private Long financial_approval;


    @Column(name = "is_taken")
    private Boolean is_taken;

    @ManyToOne
    @JoinColumn(name="employee" )
    private Employee employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Boolean getIs_approved() {
        return is_approved;
    }

    public void setIs_approved(Boolean is_approved) {
        this.is_approved = is_approved;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Boolean getIs_taken() {
        return is_taken;
    }

    public void setIs_taken(Boolean is_taken) {
        this.is_taken = is_taken;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
