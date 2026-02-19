package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // This creates a table named 'users' in your DB
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    // Getters and Setters (Standard Java boilerplate)
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}