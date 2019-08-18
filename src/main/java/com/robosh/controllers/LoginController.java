package com.robosh.controllers;

import com.robosh.model.enums.Role;
import com.robosh.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/taxi-kyiv")
public class LoginController {

    @GetMapping("/login")
    public String loginPage(HttpServletRequest request)
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
