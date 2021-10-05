package com.bezkoder.springjwt.dto;

import com.bezkoder.springjwt.models.ERole;

import javax.persistence.*;

public class RoleResponseDto {


    private Integer id;


    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
