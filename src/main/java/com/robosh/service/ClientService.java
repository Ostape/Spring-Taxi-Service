package com.robosh.service;

import com.robosh.dto.RegistrationClientDto;
import com.robosh.model.customExceptions.EmailAndPhoneNumberIsAlreadyTaken;
import com.robosh.model.customExceptions.EmailIsAlreadyTaken;
import com.robosh.model.customExceptions.PasswordNotEquals;
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

    public Client getClientByPhoneNumber(String phoneNumber) {
        return clientRepository.findByPhoneNumber(phoneNumber);
    }

    public Client registerNewClient(RegistrationClientDto clientDto) throws EmailIsAlreadyTaken, PhoneNumberIsAlreadyTaken {
        isPasswordEqual(clientDto);
        isNotDuplicatedData(clientDto);
        Client client = convertDtoClientToClientEntity(clientDto);
        return clientRepository.save(client);
    }

    private void isPasswordEqual(RegistrationClientDto clientDto) {
        if (!clientDto.getPassword().equals(clientDto.getPassword_repeat())){
            throw new PasswordNotEquals("Password not equals: " + clientDto.getPassword() + " and " +
                    clientDto.getPassword_repeat());
        }
    }

    private void isNotDuplicatedData(RegistrationClientDto clientDto) {
        if (isEmailExists(clientDto.getEmail()) && isPhoneNumberExists(clientDto.getPhone_number())) {
            throw new EmailAndPhoneNumberIsAlreadyTaken("Phone number and email is already taken:" +
                    clientDto.getPhone_number() + ", " + clientDto.getEmail());
        }

        if (isEmailExists(clientDto.getEmail())) {
            throw new EmailIsAlreadyTaken(
                    "There is an account with that email address:" + clientDto.getEmail());
        }
        if (isPhoneNumberExists(clientDto.getPhone_number())) {
            throw new PhoneNumberIsAlreadyTaken(
                    "There is an account with that phone number:" + clientDto.getPhone_number());
        }
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
