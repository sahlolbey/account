package com.ing.test.account.controller;


import com.ing.test.account.dto.AccountDTO;
import com.ing.test.account.dto.UserPrincipal;
import com.ing.test.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

/**
 * This is the Spring MVC controller class.
 */
@Controller
public class AccountController {
    public static final int WORK_TIME_START_MINUTE=0;
    public static final int WORK_TIME_START_HOUR=0;
    public static final int WORK_TIME_END_MINUTE=0;
    public static final int WORK_TIME_END_HOUR=17;
    @Autowired
    AccountService accountService;
    @RequestMapping("/")
    public String index() {
        return "dashboard";
    }

    @GetMapping("/account")
    public String accountForm(Model model){
        if(userHasAccount()){
            return "dashboard";
        }
        model.addAttribute("account", new AccountDTO());

        return "account";
    }
    @PostMapping("/account")
    public String accountSubmit(@ModelAttribute(name = "account") AccountDTO accountDTO,Model model){
        // check if the current time is allowed for creating account
        LocalTime localTime = LocalTime.now();
        LocalTime startTime = LocalTime.of(WORK_TIME_START_HOUR, WORK_TIME_START_MINUTE);
        LocalTime endTime = LocalTime.of(WORK_TIME_END_HOUR, WORK_TIME_END_MINUTE);
        if(localTime.isBefore(startTime) || localTime.isAfter(endTime)){
            model.addAttribute("error", "You can not create account at this time. Please try later");
            return "/dashboard";
        }

        if(userHasAccount()){
            return "/dashboard";
        }
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        if(userPrincipal!=null) {
            accountDTO.setUser(userPrincipal.getUser());
            accountService.saveAccount(accountDTO);
        }
        return "result";
    }
    public boolean userHasAccount(){
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return accountService.userHasAccount(userPrincipal);

    }
    public AccountDTO getAccount(){
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return  accountService.getUserAccount(userPrincipal);
    }
}
