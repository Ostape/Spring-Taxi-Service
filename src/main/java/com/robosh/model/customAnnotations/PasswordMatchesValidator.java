package com.robosh.model.customAnnotations;

import com.robosh.dto.RegistrationClientDto;
import com.robosh.model.customAnnotations.annotations.PasswordMatches;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    private Pattern pattern;
    private Matcher matcher;
    private static final String CORRECT_PASSWORD = "[a-zA-Z0-9]{5,20}";

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        RegistrationClientDto clientDto = (RegistrationClientDto) obj;
        if (clientDto.getPassword().equals(clientDto.getPassword_repeat())) {
            return checkInputPassword(clientDto.getPassword());
        }
        return false;
    }

    private boolean checkInputPassword(String password) {
        pattern = Pattern.compile(CORRECT_PASSWORD);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
