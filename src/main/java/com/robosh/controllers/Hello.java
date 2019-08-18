package com.robosh.controllers;

import com.robosh.model.entities.Client;
import com.robosh.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello {

//    @Autowired
//    private AddressRepository addressRepository;

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/main")
    public String returnMain(){

        return "main";
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
