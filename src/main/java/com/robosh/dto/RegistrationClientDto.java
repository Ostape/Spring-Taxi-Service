package com.robosh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationClientDto {
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String phone_number;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String password_repeat;
}
