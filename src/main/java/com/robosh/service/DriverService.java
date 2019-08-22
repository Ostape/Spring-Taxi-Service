package com.robosh.service;

import com.robosh.customExceptions.NoDriverAvailableException;
import com.robosh.model.entities.Driver;
import com.robosh.model.enums.DriverStatus;
import com.robosh.repository.DriverRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DriverService {
    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver getDriverByPhoneNumber(String phoneNumber) {
        return driverRepository.findByPhoneNumber(phoneNumber);
    }


    public Driver getDriverIfFree(String carType) {
        Driver driver = driverRepository.findByDriverStatusAndCarType(carType, DriverStatus.free.name());
        if (driver == null) {
            throw new NoDriverAvailableException("No driver available with such car type: " + carType);
        }
        return driver;
    }

    @Transactional
    public void updateDriver(DriverStatus driverStatus, Long idPerson) {
        driverRepository.updateDriverStatus(driverStatus.name(), idPerson);
    }
}
