/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.spring.user;

import java.util.Date;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 *
 * @author Ravilion
 */
public class User {
    
    private Integer id;
    
    @Size(min=2) 
    private String name;
    
    @Past
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", date=" + date + '}';
    }

    protected User() {
    }

    public User(Integer id, String name, Date date) {
        super();
        this.id = id;
        this.name = name;
        this.date = date;
    }
    
}
