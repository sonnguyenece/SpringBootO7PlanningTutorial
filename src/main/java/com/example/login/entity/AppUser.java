package com.example.login.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class AppUser {
    @Id
    @GeneratedValue
    @Column(name = "User_Id",nullable = false)
    private Long userId;

    @Column(name = "User_Name", length = 36, nullable = false)
    private String userName;

    @Column(name = "Encryted_Password", length = 128, nullable = false)
    private String encrytedPassword;

    @Column(name = "Enabled", length = 1, nullable = false)
    private boolean enabled;
}
