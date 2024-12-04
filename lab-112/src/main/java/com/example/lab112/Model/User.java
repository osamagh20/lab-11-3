package com.example.lab112.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @NotEmpty(message = "Enter the username")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String username;
    @NotEmpty(message = "Enter the password")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;
    @NotEmpty(message = "Enter the email")
    @Column(columnDefinition = "varchar(40) not null unique")
    private String email;
    @Column(columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private LocalDateTime registration_date;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(LocalDateTime registration_date) {
        this.registration_date = registration_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @PrePersist
    public void prePersist() {
        if (registration_date == null)
            registration_date = LocalDateTime.now();
    }

}
