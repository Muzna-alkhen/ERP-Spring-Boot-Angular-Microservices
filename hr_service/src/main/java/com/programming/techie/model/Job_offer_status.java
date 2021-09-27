package com.programming.techie.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "job_offer_status")
public class Job_offer_status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="status")
    private List<Job_offer> job_offerList ;

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

    public List<Job_offer> getJob_offerList() {
        return job_offerList;
    }

    public void setJob_offerList(List<Job_offer> job_offerList) {
        this.job_offerList = job_offerList;
    }
}
