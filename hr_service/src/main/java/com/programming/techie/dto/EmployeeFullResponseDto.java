package com.programming.techie.dto;

import com.programming.techie.model.Leaves;
import com.programming.techie.model.Month_salary;

import java.util.Date;
import java.util.List;

public class EmployeeFullResponseDto {


    private Long id;

    private String user_name;

    private String firstName;

    private String middleName;

    private String lastName;

    private Date dateOfBirth;

    private Boolean isActive;

    private String email;

    private Date joiningDate;

    private Date exitDate;

    private String address;

    private String contact;

    private String department;

    private String designation;

    private String grade;

    private List<Month_salaryDto> month_salaryList;
    private List<LeavesEmployeeDto> leavesList;

    public List<Month_salaryDto> getMonth_salaryList() {
        return month_salaryList;
    }

    public void setMonth_salaryList(List<Month_salaryDto> month_salaryList) {
        this.month_salaryList = month_salaryList;
    }

    public List<LeavesEmployeeDto> getLeavesList() {
        return leavesList;
    }

    public void setLeavesList(List<LeavesEmployeeDto> leavesList) {
        this.leavesList = leavesList;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
