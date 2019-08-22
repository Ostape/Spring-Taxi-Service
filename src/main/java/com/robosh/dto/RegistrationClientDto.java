package com.robosh.dto;

import com.robosh.customAnnotations.annotations.PasswordMatches;
import com.robosh.customAnnotations.annotations.ValidEmail;
import com.robosh.customAnnotations.annotations.ValidPhoneNumber;
import com.robosh.customAnnotations.annotations.ValidUsername;
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
    @PasswordMatches(message = "{register.password.error}")
    private String password;

    @NotNull
    @NotEmpty
    @PasswordMatches(message = "{register.password.error}")
    private String password_repeat;
}
