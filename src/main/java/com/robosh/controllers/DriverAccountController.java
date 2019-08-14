package com.robosh.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/taxi-kyiv/driver-account")
public class DriverAccountController {
    @GetMapping("/show-orders")
    public String showDriverOrders(){
        //todo order page
        return "order";
    }
}
