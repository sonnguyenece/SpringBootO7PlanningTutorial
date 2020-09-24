package com.example.demo.service;

import com.example.demo.model.BankAccount;
import com.example.demo.model.SendMoneyForm;
import com.example.demo.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;

    public List<BankAccount> getAllAccounts() {
        return bankRepository.findAll();
    }

//    public void transferTransaction(SendMoneyForm sendMoneyForm) {
//        long fromAccountId = sendMoneyForm.getFromAccountId();
//        long toAccountId = sendMoneyForm.getToAccountId();
//        double amount = sendMoneyForm.getAmount();
//    }

}
