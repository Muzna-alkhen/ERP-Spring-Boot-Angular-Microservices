package com.programming.techie.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "leave_type")
public class Leave_type {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name")
    private String name;


    @Column(name = "max")
    private int max;

    @OneToMany(mappedBy="type")
    private List<Leaves> leavesList;

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

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public List<Leaves> getLeavesList() {
        return leavesList;
    }

    public void setLeavesList(List<Leaves> leavesList) {
        this.leavesList = leavesList;
    }
}
