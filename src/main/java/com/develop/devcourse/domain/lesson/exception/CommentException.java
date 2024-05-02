package com.develop.devcourse.domain.lesson.exception;

import com.develop.devcourse.common.exeption.DomainException;

public class CommentException extends DomainException{
    public CommentException(String message) {
        super(message);
    }

    public CommentException(String message, Throwable cause) {
        super(message, cause);
    }
}
