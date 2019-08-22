package com.robosh.customAnnotations;

import com.robosh.customAnnotations.annotations.PasswordMatches;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, String> {

    private Pattern pattern;
    private Matcher matcher;
    private static final String CORRECT_PASSWORD = "[a-zA-Z0-9]{5,20}";

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return checkInputPassword(password);
    }

    private boolean checkInputPassword(String password) {
        pattern = Pattern.compile(CORRECT_PASSWORD);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
