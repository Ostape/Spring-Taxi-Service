package com.robosh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderTaxiDto {
    @NotNull
    @NotEmpty
    private String address_departure;

    @NotNull
    @NotEmpty
    private String address_arrive;

    @NotNull
    @NotEmpty
    private String carType;

    private String coupon;
}
