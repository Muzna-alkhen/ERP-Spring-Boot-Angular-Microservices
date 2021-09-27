package com.programming.techie.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "task")
public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    @Column(name = "description")
    private String description;


    @ManyToOne
    @JoinColumn(name="type")
    private Task_type type;


    @OneToMany(mappedBy="task")
    private List<Task_project_template> task_project_templateList;

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

    public Task_type getType() {
        return type;
    }

    public void setType(Task_type type) {
        this.type = type;
    }

    public List<Task_project_template> getTask_project_templateList() {
        return task_project_templateList;
    }

    public void setTask_project_templateList(List<Task_project_template> task_project_templateList) {
        this.task_project_templateList = task_project_templateList;
    }
}
