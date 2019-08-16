package com.robosh.controllers;

import com.robosh.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/taxi-kyiv")
    public String homePage(){
        System.out.println(addressRepository.getOne(1));


        return "home_page";
    }
}
