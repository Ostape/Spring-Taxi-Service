package com.robosh.controllers;


import com.robosh.model.entities.Client;
import com.robosh.model.entities.Driver;
import com.robosh.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequestMapping("/taxi-kyiv/driver-account")
public class DriverAccountController {

    @Autowired
    private final DriverService driverService;

    public DriverAccountController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    public String showDriverPage(Model model, Principal principal, HttpServletRequest request){
        Driver driver = driverService.getDriverByPhoneNumber(principal.getName());
        model.addAttribute("name", driver.getName());
        model.addAttribute("surname", driver.getSurname());
        model.addAttribute("phone_number", driver.getPhoneNumber());
        model.addAttribute("auto_type", driver.getCar().getCarType());
        model.addAttribute("status", driver.getDriverStatus());
        return "driver_account";
    }

    @GetMapping("/show-orders")
    public String showDriverOrders(){
        //todo paggination page
        return "order";
    }
}
