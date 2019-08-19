package com.robosh.repository;

import com.robosh.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.SQLIntegrityConstraintViolationException;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByPhoneNumberAndPassword(String phoneNumber, String password);
    Client findByEmail(String email);
    Client findByPhoneNumber(String phoneNumber);
}
