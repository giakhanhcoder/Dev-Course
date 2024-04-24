package com.develop.devcourse.domain.lesson.exeption;

import com.develop.devcourse.common.exeption.DomainException;

public class LessonException extends DomainException {
    public LessonException(String message) {
        super(message);
    }

    public LessonException(String message, Throwable cause) {
        super(message, cause);
    }
}
