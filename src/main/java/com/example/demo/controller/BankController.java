package com.example.demo.controller;

import com.example.demo.model.SendMoneyForm;
import com.example.demo.service.BankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class BankController {
    @Autowired
    private BankService bankService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showBankAccounts(Model model) {
        String infoMessage = (String) model.getAttribute("infoMessage");
        model.addAttribute("accountInfos", bankService.getAllAccounts());
        return "index";
    }

    @RequestMapping(value = "sendMoney", method = RequestMethod.GET)
    public String sendMoneyPage(Model model) {

        model.addAttribute("accountInfos", bankService.getAllAccounts());
        model.addAttribute("sendMoneyForm", new SendMoneyForm());

        return "sendMoneyPage";
    }

    @RequestMapping(value = "sendMoney", method = RequestMethod.POST)
    public String sendMoney(Model model, SendMoneyForm sendMoneyForm) {

        try {
            bankService.transferTransaction(sendMoneyForm);
            model.addAttribute("infoMessage", "Giao dich thanh cong");
        } catch (Exception e) {
            log.error(e.getMessage());
            model.addAttribute("infoMessage", "Giao dich that bai" + e.getMessage());
        }

        return "redirect:/";
    }
}
