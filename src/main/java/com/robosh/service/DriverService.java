package com.robosh.service;

import com.robosh.model.entities.Driver;
import com.robosh.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver getDriverByPhoneNumber(String phoneNumber) {
        return driverRepository.findByPhoneNumber(phoneNumber);
    }
}
