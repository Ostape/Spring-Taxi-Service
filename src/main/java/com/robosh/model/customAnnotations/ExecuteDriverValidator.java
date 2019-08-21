package com.robosh.model.customAnnotations;

import com.robosh.model.customAnnotations.annotations.ValidOrderInput;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExecuteDriverValidator implements ConstraintValidator<ValidOrderInput, String> {
    private Pattern pattern;
    private Matcher matcher;
    private static final String CORRECT_INPUT = "[\\D]";

    @Override
    public void initialize(ValidOrderInput constraintAnnotation) {
    }

    @Override
    public boolean isValid(String driverInput, ConstraintValidatorContext constraintValidatorContext) {
        if(driverInput == null){
            return false;
        }
        return validateOrderDriverInput(driverInput);
    }

    private boolean validateOrderDriverInput(String username) {
        pattern = Pattern.compile(CORRECT_INPUT);
        matcher = pattern.matcher(username);
        return matcher.matches();
    }
}
