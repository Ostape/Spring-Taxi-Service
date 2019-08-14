package com.robosh.controllers;

import com.robosh.model.entities.Address;
import com.robosh.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello {

//    @Autowired
//    private AddressRepository addressRepository;

    @GetMapping("/main")
    public String returnMain(Model model){
        model.addAttribute("name", "vasia");
        return "main";
    }

    @GetMapping("/home")
    public String homePage(){
        return "home";
    }

    @GetMapping("/client-acc")
    public String clientAccount(){
        return "client_account";
    }


    @GetMapping("/order-status")
    public String orderStatus(){
        return "order_status";
    }


    @GetMapping("/order-taxi")
    public String orderTaxi(){
        return "taxi_order";
    }
}
