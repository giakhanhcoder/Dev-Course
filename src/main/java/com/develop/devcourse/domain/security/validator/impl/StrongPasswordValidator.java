package com.develop.devcourse.domain.security.validator.impl;

import com.develop.devcourse.domain.security.validator.StrongPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StrongPasswordValidator implements ConstraintValidator<StrongPassword, String> {

    /**
     * ^: the start of the string
     * (?=.*\d): at least one digit
     * (?=.*[a-z]): at least one lowercase letter
     * (?=.*[A-Z]): at least one uppercase letter
     * (?=.*[@#$%^&+=!*()]): at least one special character
     * .{8,}: at least 8 characters long
     * $: the end of the string*/

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // check if string contains at least one digit, one lowercase letter, one uppercase letter, one special character and 8 characters long
        return value.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*()]).{8,}$");
    }
}
