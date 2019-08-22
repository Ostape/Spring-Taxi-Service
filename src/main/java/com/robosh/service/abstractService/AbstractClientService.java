package com.robosh.service.abstractService;

import com.robosh.dto.RegistrationClientDto;
import com.robosh.model.entities.Client;

public interface AbstractClientService {
    Client getClientByPhoneNumber(final String phoneNumber);

    Client registerNewClient(final RegistrationClientDto clientDto);
}
