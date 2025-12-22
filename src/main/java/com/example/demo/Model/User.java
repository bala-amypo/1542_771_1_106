package com.example.demo.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    // Role must be "ADMIN" or "USER"; default to "USER"
    @Column(nullable = false)
    private String role = "USER";

    public User() {
    }

    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    // Optional setter for ID if needed by JPA or tests
    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Note: store only a BCrypt-hashed password in the service layer.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter accepts the (already hashed) password value.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the role ("ADMIN" or "USER").
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role. If null is provided, keep default "USER".
     */
    public void setRole(String role) {
        if (role == null || role.isBlank()) {
            this.role = "USER";
        } else {
            this.role = role;
        }
    }
}
