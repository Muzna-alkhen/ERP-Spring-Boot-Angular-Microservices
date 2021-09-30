package com.programming.techie.model;


import javax.persistence.*;

@Entity
@Table(name = "task_project_template")
public class Task_project_template {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="task")
    private Task task;

    @ManyToOne
    @JoinColumn(name="template")
    private Project_template template;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Project_template getTemplate() {
        return template;
    }

    public void setTemplate(Project_template template) {
        this.template = template;
    }
}
