package com.develop.devcourse.domain.course.exeption;

import com.develop.devcourse.common.exeption.DomainException;

public class CourseException extends DomainException {
    public CourseException(String message) {
        super(message);
    }

    public CourseException(String message, Throwable cause) {
        super(message, cause);
    }
}
