package com.robosh.service.abstractService;

import com.robosh.dto.RegistrationClientDto;
import com.robosh.model.entities.Client;

public interface AbstractClientService {
    Client getClientByPhoneNumber(String phoneNumber);

    Client registerNewClient(RegistrationClientDto clientDto);
}
