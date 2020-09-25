package com.example.login.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "App_Role",uniqueConstraints = {
        @UniqueConstraint(name = "APP_ROLE_UK",columnNames = "Role_Name")
})
@Data
public class AppRole {
    @Id
    @GeneratedValue
    @Column(name = "Role_id",nullable = false)
    private Long roleId;

    @Column(name = "Role_Name",length = 30,nullable = false)
    private String roleName;
}
