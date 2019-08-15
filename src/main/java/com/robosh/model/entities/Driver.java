package com.robosh.model.entities;

import com.robosh.model.enums.DriverStatus;
import lombok.*;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class Driver extends Person {
    private DriverStatus driverStatus;
    private Car car;
    private String middleName;
}
