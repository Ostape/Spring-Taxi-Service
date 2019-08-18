package com.robosh.service;

import com.robosh.dto.RegistrationClientDto;
import com.robosh.model.entities.Client;
import com.robosh.model.enums.Role;
import com.robosh.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ClientService {
    private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    private static final String CORRECT_PASSWORD = "[a-zA-Z0-9]{5,20}";
    private static final String CORRECT_NAME = "[a-zA-Z\\p{IsCyrillic}]{3,20}";
    private static final String CORRECT_PHONE_NUMBER = "^(\\+380)([0-9]{9})";

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public boolean isValidClientData(RegistrationClientDto clientDto) {
        return !isNull(clientDto) && !isNotCorrectData(clientDto);
    }

    public Client convertDtoClientToClientEntity(RegistrationClientDto dto) {
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

    private boolean isNull(RegistrationClientDto dto) {
        return (dto.getName() == null || dto.getSurname() == null
                || dto.getPhone_number() == null || dto.getEmail() == null
                || dto.getPassword() == null || dto.getPassword_repeat() == null);
    }

    private static boolean isCorrectEmail(String email) {
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.matches();
    }

    private static boolean isValidPassword(String password1, String password2) {
        Pattern validPassword = Pattern.compile(CORRECT_PASSWORD);
        Matcher matcher = validPassword.matcher(password1);
        return isSamePassword(password1, password2) && matcher.matches();
    }

    private static boolean isSamePassword(String password1, String password2) {
        return password1.equals(password2);
    }

    private static boolean isCorrectName(String name) {
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile(CORRECT_NAME);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(name);
        return matcher.matches();
    }

    private static boolean isCorrectSurname(String surname) {
        return isCorrectName(surname);
    }

    private static boolean isCorrectPhoneNumber(String phoneNumber) {
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile(CORRECT_PHONE_NUMBER);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(phoneNumber);
        return matcher.matches();
    }

    private static boolean isCorrectNameSurname(String name, String surname) {
        return isCorrectName(name) && isCorrectSurname(surname);
    }

    public static boolean isNotCorrectData(RegistrationClientDto dto) {
        return !(isCorrectNameSurname(dto.getName(), dto.getSurname()) && isCorrectPhoneNumber(dto.getPhone_number())
                && isCorrectEmail(dto.getEmail()) && isValidPassword(dto.getPassword(), dto.getPassword_repeat()));
    }

}
