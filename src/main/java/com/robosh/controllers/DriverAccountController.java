package com.robosh.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/taxi-kyiv/driver-account")
public class DriverAccountController {
    @GetMapping
    public String showDriverPage(){
        System.out.println("in driver");
        return "driver_account";
    }

    @GetMapping("/show-orders")
    public String showDriverOrders(){
        //todo paggination page
        return "order";
    }
}
