package com.develop.devcourse.domain.security.exeption;

public class LoginFailException extends RuntimeException{

    public LoginFailException(String message){
        super(message);
    }
}
