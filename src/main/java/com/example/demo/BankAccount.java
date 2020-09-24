package com.example.demo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Bank_Account")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 128,nullable = false)
    String fullName;
    @Column(nullable = false)
    double balance;
}
