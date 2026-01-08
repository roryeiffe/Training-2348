package com.revature.demo.dto;

public class LoginDTO {
    // Data Transfer Object, useful for when we need to send data in a request that isn't
    // already an entity
    private String username;
    private String password;

    public LoginDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
