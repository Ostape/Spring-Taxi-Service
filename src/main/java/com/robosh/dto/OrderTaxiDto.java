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
    private Long id_address_departure;

    @NotNull
    private Long id_address_arrive;

    @NotNull
    @NotEmpty(message = "{order.taxi.select.error}")
    private String carType;

    private String coupon;
}
