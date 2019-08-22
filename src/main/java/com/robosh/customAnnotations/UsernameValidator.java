package com.robosh.customAnnotations;

import com.robosh.customAnnotations.annotations.ValidUsername;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameValidator implements ConstraintValidator<ValidUsername, String> {

    private Pattern pattern;
    private Matcher matcher;
    private static final String CORRECT_NAME = "[a-zA-Z\\p{IsCyrillic}]{3,20}";

    @Override
    public void initialize(ValidUsername constraintAnnotation) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        if (username == null) {
            return false;
        }
        return validateUsername(username);
    }

    private boolean validateUsername(String username) {
        pattern = Pattern.compile(CORRECT_NAME);
        matcher = pattern.matcher(username);
        return matcher.matches();
    }
}
