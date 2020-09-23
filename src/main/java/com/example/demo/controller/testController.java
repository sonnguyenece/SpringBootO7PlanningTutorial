package com.example.demo.controller;

import com.example.demo.BankAccount;
import com.example.demo.repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class testController {
@Autowired
private TestRepo testRepo;

    @RequestMapping("/")
    @ResponseBody
    public Object getAll(){
        List<BankAccount> list =testRepo.findAll();
        return list;
    }
}
