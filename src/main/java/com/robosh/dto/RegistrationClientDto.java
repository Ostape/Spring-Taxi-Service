package com.robosh.dto;

import com.robosh.model.customAnnotations.annotations.PasswordMatches;
import com.robosh.model.customAnnotations.annotations.ValidEmail;
import com.robosh.model.customAnnotations.annotations.ValidUsername;
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
@PasswordMatches
public class RegistrationClientDto {
    @NotNull
    @NotEmpty
    @ValidUsername
    private String name;

    @NotNull
    @NotEmpty
    @ValidUsername
    private String surname;

    @NotNull
    @NotEmpty
    private String phone_number;

    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String password_repeat;
}
