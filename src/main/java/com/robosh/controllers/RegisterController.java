package com.robosh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/taxi-kyiv")
public class RegisterController {
    @GetMapping("/register-client")
    public String registerClient(){
        return "register_client";
    }
}
