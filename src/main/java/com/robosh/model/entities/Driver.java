package com.robosh.model.entities;

import com.robosh.model.enums.DriverStatus;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(callSuper=true, includeFieldNames=true)

@Entity
@Table(name = "driver")
public class Driver extends Person {
    private DriverStatus driverStatus;
    private Car car;
    private String middleName;
}
