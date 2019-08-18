package com.robosh.model.entities;

import com.robosh.model.enums.DriverStatus;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(callSuper = true, includeFieldNames = true)
@Entity
public class Driver extends Person {
    @Enumerated(value = EnumType.STRING)
    private DriverStatus driverStatus;

    @OneToOne
    @JoinColumn(name = "id_car")
    private Car car;
    private String middleName;
}
