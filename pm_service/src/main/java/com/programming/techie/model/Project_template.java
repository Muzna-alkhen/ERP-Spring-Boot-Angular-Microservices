package com.programming.techie.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project_template")
public class Project_template {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy="template")
    private List<Task_project_template> task_project_templateList;

    @OneToMany(mappedBy="template")
    private List<Project> projectList;

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

    public List<Task_project_template> getTask_project_templateList() {
        return task_project_templateList;
    }

    public void setTask_project_templateList(List<Task_project_template> task_project_templateList) {
        this.task_project_templateList = task_project_templateList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
