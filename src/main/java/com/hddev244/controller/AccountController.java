package com.hddev244.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hddev244.entity.Account;
import com.hddev244.service.AccountService;
import com.hddev244.service.scope.SessionService;

@Controller
@RequestMapping(value = "account")
public class AccountController {
      @Autowired
      AccountService accountService;
      @Autowired
      SessionService session;

      @PostMapping(value = "register")
      public String register(
                  @ModelAttribute("account") Account account,
                  Model model) {

            Optional<Account> accountCreated = accountService.register(account);
            if(accountCreated.isPresent()) {
                  model.addAttribute("registerMes", "dang ki thanh cong");
                  session.set("account", accountCreated);
            } else {
                  model.addAttribute("registerMes", "Tai khoan da ton tai"); 
            }
            model.addAttribute("locationForm",false);
            return "pages/login";
      }
}
