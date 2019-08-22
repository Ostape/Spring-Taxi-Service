package com.robosh.service.abstractService;

import com.robosh.model.entities.Driver;

public interface AbstractDriverService {
    Driver getDriverByPhoneNumber(final String phoneNumber);

    Driver getDriverIfFree(final String carType);
}
