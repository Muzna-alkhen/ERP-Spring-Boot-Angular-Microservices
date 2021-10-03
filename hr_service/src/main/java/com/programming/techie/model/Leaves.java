package com.programming.techie.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "leaves")
public class Leaves {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "submit_date")
    private Date submit_date;

    @Column(name = "approval_date")
    private Date approval_date;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "approval")
    private String approval;


    @ManyToOne
    @JoinColumn(name="type")
    private Leave_type type;

    @ManyToOne
    @JoinColumn(name="status")
    private Leave_status status;

    @ManyToOne
    @JoinColumn(name="employee")
    private Employee employee;

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

    public Leave_type getType() {
        return type;
    }

    public void setType(Leave_type type) {
        this.type = type;
    }

    public Leave_status getStatus() {
        return status;
    }

    public void setStatus(Leave_status status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }
}
