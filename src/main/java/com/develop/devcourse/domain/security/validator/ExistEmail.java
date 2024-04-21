package com.develop.devcourse.domain.security.validator;


import com.develop.devcourse.domain.security.validator.impl.ExistEmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ExistEmailValidator.class)
@Documented
public @interface ExistEmail {
    String message() default "Account is created by email";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
