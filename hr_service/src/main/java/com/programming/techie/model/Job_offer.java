package com.programming.techie.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "job_offer")
public class Job_offer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "qualifications", length = 100)
    private String qualifications;

    @Column(name = "number", length = 100)
    private int number;

    @Column(name = "submit_date")
    private Date submit_date;

    @OneToMany(mappedBy="job_offer")
    private List<Job_applicant> job_applicantList;

    @ManyToOne
    @JoinColumn(name="status" )
    private Job_offer_status status;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getSubmit_date() {
        return submit_date;
    }

    public void setSubmit_date(Date submit_date) {
        this.submit_date = submit_date;
    }

    public List<Job_applicant> getJob_applicantList() {
        return job_applicantList;
    }

    public void setJob_applicantList(List<Job_applicant> job_applicantList) {
        this.job_applicantList = job_applicantList;
    }

    public Job_offer_status getStatus() {
        return status;
    }

    public void setStatus(Job_offer_status status) {
        this.status = status;
    }
}
