package com.programming.techie.dto;

import com.programming.techie.model.Employee;
import com.programming.techie.model.Leave_status;
import com.programming.techie.model.Leave_type;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class LeavesFullDto {

    private Long id;
    private Date submit_date;
    private Date approval_date;
    private Date start_date;
    private Date end_date;
    private String approval;
    private String type;
    private String status;
    private Long employee;

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

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getEmployee() {
        return employee;
    }

    public void setEmployee(Long employee) {
        this.employee = employee;
    }
}
