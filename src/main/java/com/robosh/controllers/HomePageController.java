package com.robosh.controllers;

import com.robosh.repository.AddressRepository;
import com.robosh.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @Autowired
    public AddressRepository addressRepository;

    @Autowired
    public DriverRepository driverRepository;

    @GetMapping("/taxi-kyiv")
    public String homePage(){
        System.out.println(addressRepository.findByIdAddress(1L));
        System.out.println(driverRepository.findById(1L).get());
        return "home_page";
    }
}
