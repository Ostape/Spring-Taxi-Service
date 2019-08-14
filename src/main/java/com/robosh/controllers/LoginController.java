package com.robosh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/taxi-kyiv")
public class LoginController {
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/enterLogin")
    public String enterLogin(){
        //todo
        return "redirect:/taxi-kyiv/client-account";
    }
}
