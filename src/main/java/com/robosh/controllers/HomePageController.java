package com.robosh.controllers;

import com.robosh.service.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    private final Logger logger = LogManager.getLogger(ClientService.class);

    @GetMapping("/taxi-kyiv")
    public String homePage() {
        logger.info("/taxi-kyiv " + "home page");
        return "home_page";
    }
}
