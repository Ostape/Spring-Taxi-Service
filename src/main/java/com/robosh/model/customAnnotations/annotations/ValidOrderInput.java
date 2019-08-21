package com.robosh.model.customAnnotations.annotations;

import com.robosh.model.customAnnotations.ExecuteDriverValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ExecuteDriverValidator.class)
@Documented
public @interface ValidOrderInput {
    String message() default "Invalid order input";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
