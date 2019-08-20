package com.robosh.dto;

import com.robosh.model.customAnnotations.annotations.PasswordMatches;
import com.robosh.model.customAnnotations.annotations.ValidEmail;
import com.robosh.model.customAnnotations.annotations.ValidPhoneNumber;
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
    @ValidUsername(message = "{register.name.error}")
    private String name;

    @NotNull
    @NotEmpty
    @ValidUsername(message = "{register.name.error}")
    private String surname;

    @NotNull
    @NotEmpty
    @ValidPhoneNumber(message = "{register.phone.number.error}")
    private String phone_number;

    @NotNull
    @NotEmpty
    @ValidEmail(message = "{register.email.wrong.regex}")
    private String email;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String password_repeat;
}
