package com.programming.techie.model;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "applicant_status")
public class Job_applicant_status {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="status")
    private List<Job_applicant> job_applicantList;

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

    public List<Job_applicant> getJob_applicantList() {
        return job_applicantList;
    }

    public void setJob_applicantList(List<Job_applicant> job_applicantList) {
        this.job_applicantList = job_applicantList;
    }
}
