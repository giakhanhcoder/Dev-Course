package com.develop.devcourse.domain.student.exception;

import com.develop.devcourse.common.exeption.DomainException;

public class StudentException extends DomainException {
    public StudentException(String message){
        super(message);
    }
    public StudentException(String message, Throwable cause){
        super(message, cause);
    }
}
