package com.robosh.controllers;


import com.robosh.model.entities.Client;
import com.robosh.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/taxi-kyiv/client-account")
public class ClientAccountController {

    @Autowired
    public ClientRepository clientRepository;

    @GetMapping
    public String showClientAccountPage(){

        Client client =
                clientRepository.findByPhoneNumberAndPassword("+380976970365", "rootroot");

        System.out.println("Client");
        System.out.println(client);

        return "client_account";
    }
}
