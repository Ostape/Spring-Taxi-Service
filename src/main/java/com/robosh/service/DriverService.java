package com.robosh.service;

import com.robosh.customExceptions.NoDriverAvailableException;
import com.robosh.model.entities.Driver;
import com.robosh.model.enums.DriverStatus;
import com.robosh.repository.DriverRepository;
import com.robosh.service.abstractService.AbstractDriverService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService implements AbstractDriverService {
    private final Logger logger = LogManager.getLogger(DriverService.class);
    private final DriverRepository driverRepository;

    @Autowired
    public DriverService(final DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Driver getDriverByPhoneNumber(final String phoneNumber) {
        logger.info("get driver by phone number: " + phoneNumber);
        return driverRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Driver getDriverIfFree(final String carType) {
        logger.info("get driver if driver status is free by car type: " + carType);
        Driver driver = driverRepository.findByDriverStatusAndCarType(carType, DriverStatus.free.name());
        if (driver == null) {
            throw new NoDriverAvailableException("No driver available with such car type: " + carType);
        }
        return driver;
    }
}
