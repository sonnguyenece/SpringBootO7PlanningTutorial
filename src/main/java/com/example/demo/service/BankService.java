package com.example.demo.service;

import com.example.demo.model.BankAccount;
import com.example.demo.model.SendMoneyForm;
import com.example.demo.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;

    public List<BankAccount> getAllAccounts() {
        return bankRepository.findAll();
    }

@Transactional(rollbackFor = Exception.class)
    public void transferTransaction(SendMoneyForm sendMoneyForm) throws Exception {
        long fromAccountId = sendMoneyForm.getFromAccountId();
        long toAccountId = sendMoneyForm.getToAccountId();
        double amount = sendMoneyForm.getAmount();

        BankAccount fromAccount = bankRepository.findById(fromAccountId).get();
        if (amount > fromAccount.getBalance() - 50) {
            return;
        } else {
            BankAccount toAccount = bankRepository.findById(toAccountId).get();

            fromAccount.setBalance(fromAccount.getBalance() - amount);
            bankRepository.save(fromAccount);
            if (fromAccount.getBalance() <= 300) throw new Exception("het tien");
            toAccount.setBalance(toAccount.getBalance() + amount);
            bankRepository.save(toAccount);

        }
    }

}
