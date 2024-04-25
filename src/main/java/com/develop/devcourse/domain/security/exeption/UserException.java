package com.develop.devcourse.domain.security.exeption;

import com.develop.devcourse.common.exeption.DomainException;

public class UserException extends DomainException {

    public UserException(String message){
        super(message);
    }
    public UserException(String message, Throwable cause){
        super(message, cause);
    }
}
