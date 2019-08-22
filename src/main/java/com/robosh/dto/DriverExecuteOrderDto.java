package com.robosh.dto;

import com.robosh.customAnnotations.annotations.ValidOrderInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DriverExecuteOrderDto {

    @NotNull
    @ValidOrderInput(message = "{driver.account.mess.error}")
    private String numOfOrder;
}
