package com.programming.techie.dto;

import com.programming.techie.model.Job_applicant_status;
import com.programming.techie.model.Job_offer;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class Job_applicantResponseDto {


    private Long id;
    private String firstName;
    private Boolean is_on_boarding;
    private String email;
    private Date applicant_date;
    private String cv_path;
    private String status;
    private String job_offer_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Boolean getIs_on_boarding() {
        return is_on_boarding;
    }

    public void setIs_on_boarding(Boolean is_on_boarding) {
        this.is_on_boarding = is_on_boarding;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getApplicant_date() {
        return applicant_date;
    }

    public void setApplicant_date(Date applicant_date) {
        this.applicant_date = applicant_date;
    }

    public String getCv_path() {
        return cv_path;
    }

    public void setCv_path(String cv_path) {
        this.cv_path = cv_path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJob_offer_name() {
        return job_offer_name;
    }

    public void setJob_offer_name(String job_offer_name) {
        this.job_offer_name = job_offer_name;
    }
}
