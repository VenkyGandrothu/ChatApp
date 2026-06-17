package com.chatapp.www.entity;

public class user {
            
    private Long Id;
    private String name;
    private String email;

    
    public Long getId() {
        return Id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        Id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public user(Long id, String name, String email) {
        Id = id;
        this.name = name;
        this.email = email;
    }

    public user() {
    }

    
}


