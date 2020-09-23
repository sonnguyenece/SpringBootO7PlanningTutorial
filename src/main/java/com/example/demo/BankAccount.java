package com.example.demo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class BankAccount {
    @Id
    Long id;
    String fullName;
    Long balance;
}
