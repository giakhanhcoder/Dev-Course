package com.develop.devcourse.domain.security.validator.impl;

import com.develop.devcourse.domain.security.validator.ValidPhone;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<ValidPhone, String> {
    private static final String PHONE_PATTERN = "^(03|09)\\d{8}$";

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {

        return phone.matches(PHONE_PATTERN);
    }
}
