package com.robosh.controllers;

import com.robosh.dto.RegistrationClientDto;
import com.robosh.model.customExceptions.EmailIsAlreadyTaken;
import com.robosh.model.customExceptions.PhoneNumberIsAlreadyTaken;
import com.robosh.model.entities.Client;
import com.robosh.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/taxi-kyiv/register-client")
public class RegisterController {
    private final ClientService clientService;

    public RegisterController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String registerPage(Model model){
        RegistrationClientDto clientDto = new RegistrationClientDto();
        model.addAttribute("client", clientDto);
        return "register_client";
    }

    @PostMapping
    public ModelAndView registerClient(@ModelAttribute("client") @Valid RegistrationClientDto dto,
                                       BindingResult result, WebRequest request, Errors errors){
        Client registered = new Client();
        if (!result.hasErrors()) {
            System.out.println("creating user");
            registered = createUserAccount(dto, result);
        }
        if (registered == null) {
            System.out.println("email");


            result.rejectValue("email", "message.regError");
        }
        if (result.hasErrors()) {
            System.out.println("here");
            return new ModelAndView("register_client", "client", dto);
        }
        else {
            return new ModelAndView("login", "client", dto);
        }
    }

    private Client createUserAccount(RegistrationClientDto accountDto, BindingResult result) {
        Client registered = null;
        try {
            registered = clientService.registerNewClient(accountDto);
        } catch (EmailIsAlreadyTaken e) {
            return null;
        } catch (PhoneNumberIsAlreadyTaken e){
            return null;
        }
        return registered;
    }
}
