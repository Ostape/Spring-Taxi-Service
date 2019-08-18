package com.robosh.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/taxi-kyiv/client-account")
public class ClientAccountController {

    @GetMapping
    public String showClientAccountPage(){
        return "client_account";
    }
}
