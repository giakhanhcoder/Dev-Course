package com.develop.devcourse.domain.student.exception;

import com.develop.devcourse.common.exeption.DomainException;

public class StuentException extends DomainException {
    public StuentException(String message){
        super(message);
    }
    public StuentException(String message, Throwable cause){
        super(message, cause);
    }
}
