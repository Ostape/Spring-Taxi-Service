package com.robosh.model.entities;

import com.robosh.model.enums.DriverStatus;
import com.robosh.model.enums.Role;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(callSuper=true, includeFieldNames=true)

@Entity
@Table(name = "driver")
public class Driver extends Person {
    @Enumerated(value = EnumType.STRING)
    private DriverStatus driverStatus;

    @OneToOne
    @JoinColumn(name="id_car")
    private Car car;
    private String middleName;

    {
        roles = Role.DRIVER;
    }
}
