package com.robosh.controllers;

import com.robosh.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/taxi-kyiv")
public class LoginController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/login")
    public String loginPage()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {

            /* The user is logged in :) */
            return "redirect:/taxi-kyiv/client-account";
        }
        return "login";
    }

    @PostMapping("/login")
    public String enterLogin(){
        //todo
        return "redirect:/taxi-kyiv/client-account";
    }
}
