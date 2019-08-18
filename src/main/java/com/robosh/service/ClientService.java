package com.robosh.service;

import com.robosh.dto.RegistrationClientDto;
import com.robosh.model.entities.Client;
import com.robosh.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void saveClient(Client client){
        clientRepository.save(client);
    }

    public boolean isValidClientData(RegistrationClientDto clientDto){
        clientDto.
        return true;
    }
}
