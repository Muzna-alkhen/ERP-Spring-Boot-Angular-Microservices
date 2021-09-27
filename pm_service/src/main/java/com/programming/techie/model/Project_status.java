package com.programming.techie.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "project_status")
public class Project_status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy="status")
    private List<Project> projectList;
}
