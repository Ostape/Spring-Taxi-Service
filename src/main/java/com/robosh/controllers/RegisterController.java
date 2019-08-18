package com.robosh.controllers;

import com.robosh.dto.RegistrationClientDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/taxi-kyiv/register-client")
public class RegisterController {
    @GetMapping
    public String registerPage(){
        return "register_client";
    }

    @PostMapping
    public String registerClient(RegistrationClientDto dto){
        System.out.println(dto);
        return "redirect:/taxi-kyiv/login";
    }
}
