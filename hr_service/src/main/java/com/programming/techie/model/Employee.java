package com.programming.techie.model;

import java.util.*;
import javax.persistence.*;



@Entity
@Table(name = "employee")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", length = 100)
    private Long user_name;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "middle_name", length = 100)
    private String middleName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "email")
    private String email;

    @Column(name = "joining_date")
    private Date joiningDate;

    @Column(name = "exit_date")
    private Date exitDate;

    @Column(name = "address", length = 300)
    private String address;

    @Column(name = "contact", length = 100)
    private String contact;





    @ManyToOne
    @JoinColumn(name="department")
    private Department department;

    @ManyToOne
    @JoinColumn(name="designation")
    private Designation designation;

    @ManyToOne
    @JoinColumn(name="grade" )
    private Grade grade;

    @OneToMany(mappedBy="employee")
    private List<Month_salary> month_salaryList;

    @OneToMany(mappedBy="employee")
    private List<Leaves> leavesList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_name() {
        return user_name;
    }

    public void setUser_name(Long user_name) {
        this.user_name = user_name;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public List<Month_salary> getMonth_salaryList() {
        return month_salaryList;
    }

    public void setMonth_salaryList(List<Month_salary> month_salaryList) {
        this.month_salaryList = month_salaryList;
    }

    public List<Leaves> getLeavesList() {
        return leavesList;
    }

    public void setLeavesList(List<Leaves> leavesList) {
        this.leavesList = leavesList;
    }
}

