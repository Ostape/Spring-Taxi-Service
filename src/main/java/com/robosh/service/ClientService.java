package com.robosh.service;

import com.robosh.customExceptions.EmailAndPhoneNumberIsAlreadyTaken;
import com.robosh.customExceptions.EmailIsAlreadyTaken;
import com.robosh.customExceptions.PasswordNotEquals;
import com.robosh.customExceptions.PhoneNumberIsAlreadyTaken;
import com.robosh.dto.RegistrationClientDto;
import com.robosh.model.entities.Client;
import com.robosh.model.enums.Role;
import com.robosh.repository.ClientRepository;
import com.robosh.service.abstractService.AbstractClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientService implements AbstractClientService {
    private final Logger logger = LogManager.getLogger(ClientService.class);
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(final ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client getClientByPhoneNumber(final String phoneNumber) {
        logger.info("get client by phone number" + phoneNumber);
        return clientRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Client registerNewClient(final RegistrationClientDto clientDto)
            throws EmailIsAlreadyTaken, PhoneNumberIsAlreadyTaken {
        isPasswordEqual(clientDto);
        isNotDuplicatedData(clientDto);
        Client client = convertDtoClientToClientEntity(clientDto);
        return clientRepository.save(client);
    }

    private void isPasswordEqual(final RegistrationClientDto clientDto) {
        String password = clientDto.getPassword();
        String passwordRepeat = clientDto.getPassword_repeat();

        if (!password.equals(passwordRepeat)) {
            throw new PasswordNotEquals("Password not equals: " + password
                    + " and " + passwordRepeat);
        }
    }

    private void isNotDuplicatedData(final RegistrationClientDto clientDto) {
        String phoneNumber = clientDto.getPhone_number();
        String email = clientDto.getEmail();

        if (isEmailExists(email) && isPhoneNumberExists(phoneNumber)) {
            throw new EmailAndPhoneNumberIsAlreadyTaken("Phone number and email is already taken:" +
                    phoneNumber + ", " + email);
        }
        if (isEmailExists(email)) {
            throw new EmailIsAlreadyTaken(
                    "There is an account with that email address:" + email);
        }
        if (isPhoneNumberExists(phoneNumber)) {
            throw new PhoneNumberIsAlreadyTaken(
                    "There is an account with that phone number:" + phoneNumber);
        }
    }

    private Client convertDtoClientToClientEntity(final RegistrationClientDto dto) {
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

    private boolean isEmailExists(final String email) {
        Client client = clientRepository.findByEmail(email);
        return client != null;
    }

    private boolean isPhoneNumberExists(final String phoneNumber) {
        Client client = clientRepository.findByPhoneNumber(phoneNumber);
        return client != null;
    }
}
