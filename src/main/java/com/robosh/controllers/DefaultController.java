package com.robosh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DefaultController {
    @GetMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_CLIENT")) {
            return "redirect:/taxi-kyiv/client-account/";
        }
        return "redirect:/taxi-kyiv/driver-account";
    }
}
