package com.robosh.service;

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

//
//
//    public Driver bookDriver(String carType){
//        Driver driver = getDriverIfFree(carType);
//        return driver == null ? null :  driver.setDriverStatus(DriverStatus.booked);
//    }

    public Driver getDriverIfFree(String carType) {
        return driverRepository.findByDriverStatusAndCarType(carType, DriverStatus.free.name());
    }

    @Transactional
    public void updateDriver(DriverStatus driverStatus, Long idPerson) {
        driverRepository.updateDriverStatus(driverStatus.name(), idPerson);
    }
}
