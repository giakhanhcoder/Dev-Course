package com.develop.devcourse.domain.payment.exeption;

import com.develop.devcourse.common.exeption.DomainException;

public class PaymentException extends DomainException {
    public PaymentException(String message) {
        super(message);
    }

    public PaymentException(String message, Throwable cause) {
        super(message, cause);
    }
}
