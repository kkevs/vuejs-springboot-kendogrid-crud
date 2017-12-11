package com.vue.crud.model;


import javax.persistence.Entity;

@Entity
public class User extends Model {
    private String name;

    private String username;

    public User(String name, String username) {
        this.name = name;
        this.username = username;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
