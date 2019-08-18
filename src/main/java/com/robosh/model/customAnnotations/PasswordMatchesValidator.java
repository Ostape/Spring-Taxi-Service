package com.robosh.model.customAnnotations;

import com.robosh.dto.RegistrationClientDto;
import com.robosh.model.customAnnotations.annotations.PasswordMatches;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        RegistrationClientDto clientDto = (RegistrationClientDto) obj;
        return clientDto.getPassword().equals(clientDto.getPassword_repeat());
    }
}