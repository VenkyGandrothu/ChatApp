package com.chatapp.www.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long Id;

    @Column(name = "user_name")
    private String name;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password")
    private String password;
    @Column(name = "createAt")
    private LocalDateTime createAt;

    //getters
    public Long getId() {
        return Id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public LocalDateTime getCreateAt() {
        return createAt;
    }


    //setters
    public void setId(Long id) {
        Id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }   


    public User(Long id, String name, String email) {
        Id = id;
        this.name = name;
        this.email = email;
    }

    public User() {
    }

    
}


