package com.programming.techie.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "leave_status")
public class Leave_status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy="status")
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

    public List<Leaves> getLeavesList() {
        return leavesList;
    }

    public void setLeavesList(List<Leaves> leavesList) {
        this.leavesList = leavesList;
    }
}
