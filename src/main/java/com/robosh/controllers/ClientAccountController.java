package com.robosh.controllers;


import com.robosh.model.entities.Client;
import com.robosh.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/taxi-kyiv/client-account")
public class ClientAccountController {

    private final ClientService clientService;

    public ClientAccountController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String showClientAccountPage(Model model, Principal principal) {
        Client client = clientService.getClientByPhoneNumber(principal.getName());
        model.addAttribute("name", client.getName());
        model.addAttribute("surname", client.getSurname());
        model.addAttribute("email", client.getEmail());
        model.addAttribute("phone_number", client.getPhoneNumber());
        return "client_account";
    }
}
