package com.robosh.service;

import com.robosh.dto.RegistrationClientDto;
import com.robosh.model.customExceptions.EmailIsAlreadyTaken;
import com.robosh.model.customExceptions.PhoneNumberIsAlreadyTaken;
import com.robosh.model.entities.Client;
import com.robosh.model.enums.Role;
import com.robosh.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client getClientByPhoneNumber(String phoneNumber){
        return clientRepository.findByPhoneNumber(phoneNumber);
    }

    public Client registerNewClient(RegistrationClientDto clientDto) throws EmailIsAlreadyTaken, PhoneNumberIsAlreadyTaken {
        if (isEmailExists(clientDto.getEmail())) {
            throw new EmailIsAlreadyTaken(
                    "There is an account with that email address:"  + clientDto.getEmail());
        }
        if (isPhoneNumberExists(clientDto.getPhone_number())) {
            throw new PhoneNumberIsAlreadyTaken(
                    "There is an account with that phone number:" + clientDto.getPhone_number());
        }
        Client client = convertDtoClientToClientEntity(clientDto);
        return clientRepository.save(client);
    }

    private Client convertDtoClientToClientEntity(RegistrationClientDto dto) {
        return Client.clientBuilder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhone_number())
                .password(dto.getPassword())
                .role(Role.CLIENT)
                .active(true)
                .build();
    }

    private boolean isEmailExists(String email) {
        Client client = clientRepository.findByEmail(email);
        return client != null;
    }

    private boolean isPhoneNumberExists(String phoneNumber) {
        Client client = clientRepository.findByPhoneNumber(phoneNumber);
        return client != null;
    }
}
