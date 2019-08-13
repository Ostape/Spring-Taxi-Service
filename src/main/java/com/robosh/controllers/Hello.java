package com.robosh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/m")
public class Hello {
    @GetMapping("/maim")
    public String returnMain(){
        return "main";
    }
}
