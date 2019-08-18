package com.robosh.controllers;

import com.robosh.dto.RegistrationClientDto;
import com.robosh.model.entities.Client;
import com.robosh.model.enums.Role;
import com.robosh.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/taxi-kyiv/register-client")
public class RegisterController {
    private final ClientService clientService;

    public RegisterController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String registerPage(){
        return "register_client";
    }

    @PostMapping
    public String registerClient(RegistrationClientDto dto){

        //todo validation
        Client client = Client.clientBuilder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhone_number())
                .password(dto.getPassword())
                .role(Role.CLIENT)
                .active(true)
                .build();


        clientService.saveClient(client);
        System.out.println(dto);
        return "redirect:/taxi-kyiv/login";
    }
}
