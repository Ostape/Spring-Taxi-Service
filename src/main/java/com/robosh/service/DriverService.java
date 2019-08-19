package com.robosh.service;

import com.robosh.model.entities.Driver;
import com.robosh.model.enums.DriverStatus;
import com.robosh.repository.DriverRepository;
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

    public Driver getDriverByDriverStatusAndCarType(String carType, DriverStatus driverStatus){
        return driverRepository.findByDriverStatusAndCarType(carType, driverStatus);
    }

    public boolean checkIfDriverIsFree(String carType) {
        return driverRepository.findByDriverStatusAndCarType(carType, DriverStatus.free) != null;
    }
}
