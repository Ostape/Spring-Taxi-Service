package com.robosh.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private int idCar;
    private String carNumber;
    private String brand;
    private String color;
    private String carType;
}
