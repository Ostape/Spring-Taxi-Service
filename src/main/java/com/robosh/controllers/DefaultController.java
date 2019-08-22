package com.robosh.controllers;

import com.robosh.model.enums.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;

@Controller
public class DefaultController {
    @GetMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = new HashSet<>(auth.getAuthorities());
        boolean isClient = authorities.contains(new SimpleGrantedAuthority(Role.CLIENT.name()));

        if (isClient) {
            return "redirect:/taxi-kyiv/client-account/";
        }
        return "redirect:/taxi-kyiv/driver-account";
    }
}
