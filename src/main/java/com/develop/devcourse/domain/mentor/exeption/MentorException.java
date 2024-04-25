package com.develop.devcourse.domain.mentor.exeption;

import com.develop.devcourse.common.exeption.DomainException;

public class MentorException extends DomainException {
    public MentorException(String message) {
        super(message);
    }


    public MentorException(String message, Throwable cause) {
        super(message, cause);
    }
}
