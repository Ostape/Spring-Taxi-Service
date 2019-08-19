package com.robosh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping("/taxi-kyiv")
    public String homePage() {
        return "home_page";
    }
}
