package com.robosh.controllers;

import com.robosh.repository.AddressRepository;
import com.robosh.repository.DriverRepository;
import com.robosh.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/taxi-kyiv")
    public String homePage(){
        return "home_page";
    }
}
