package com.programming.techie.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "job_applicant")
public class Job_applicant {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "middle_name", length = 100)
    private String middleName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "is_on_boarding")
    private Boolean is_on_boarding;

    @Column(name = "email")
    private String email;

    @Column(name = "applicant_date")
    private Date applicant_date;


    @Column(name = "cv_path")
    private String cv_path;


    @Column(name = "details")
    private String details;

    @ManyToOne
    @JoinColumn(name="status" )
    private Job_applicant_status status;



    @ManyToOne
    @JoinColumn(name="job_offer" )
    private Job_offer job_offer;

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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Job_applicant_status getStatus() {
        return status;
    }

    public void setStatus(Job_applicant_status status) {
        this.status = status;
    }

    public Job_offer getJob_offer() {
        return job_offer;
    }

    public void setJob_offer(Job_offer job_offer) {
        this.job_offer = job_offer;
    }
}
