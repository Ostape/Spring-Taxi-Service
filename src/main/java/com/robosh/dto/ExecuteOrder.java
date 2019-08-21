package com.robosh.dto;

import com.robosh.model.customAnnotations.annotations.ValidOrderInput;
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
public class ExecuteOrder {

    @NotNull
    @NotEmpty
    @ValidOrderInput
    private String executeOrder;
}
