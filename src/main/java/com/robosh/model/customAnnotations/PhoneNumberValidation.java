package com.robosh.model.customAnnotations;

import com.robosh.model.customAnnotations.annotations.ValidPhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidation implements ConstraintValidator<ValidPhoneNumber, String> {

    private Pattern pattern;
    private Matcher matcher;
    private static final String CORRECT_PHONE_NUMBER = "^(\\+380)([0-9]{9})";

    @Override
    public void initialize(ValidPhoneNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        return phoneNumberValidation(phoneNumber);
    }

    private boolean phoneNumberValidation(String phoneNumber) {
        pattern = Pattern.compile(CORRECT_PHONE_NUMBER);
        matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
