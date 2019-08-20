package com.robosh.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.HashSet;

@Controller
@RequestMapping("/taxi-kyiv")
public class LoginController {

    @GetMapping("/login")
    public String loginPage()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = new HashSet<>(auth.getAuthorities());
        boolean isClient = authorities.contains(new SimpleGrantedAuthority("CLIENT"));
        boolean isDriver = authorities.contains(new SimpleGrantedAuthority("DRIVER"));

        if (isClient) {
            return "redirect:/taxi-kyiv/client-account";
        }
        if (isDriver) {
            return "redirect:/taxi-kyiv/driver-account";
        }
        return "login";
    }
}
