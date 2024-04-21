package com.develop.devcourse.common.exeption;

public class DomainException extends RuntimeException{
    public DomainException(String message) {
        super(message);
    }
    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }

    public static DomainException notFound(String message) {
        return new DomainException("Not Found: " + message);
    }

    public static DomainException badRequest(String message) {
        return new DomainException("Bad Request: " + message);
    }

    public static DomainException unauthorized(String message) {
        return new DomainException("Unauthorized: " + message);
    }

    public static DomainException internalServerError(String message) {
        return new DomainException("Internal Server Error: " + message);
    }

    public static DomainException conflict(String message) {
        return new DomainException("Conflict: " + message);
    }

    public static DomainException validationError(String message) {
        return new DomainException("Validation Error: " + message);
    }
    public static DomainException forbidden(String message) {
        return new DomainException("Forbidden: " + message);
    }

    public static DomainException methodNotAllowed(String message) {
        return new DomainException("Method Not Allowed: " + message);
    }

    public static DomainException unsupportedMediaType(String message) {
        return new DomainException("Unsupported Media Type: " + message);
    }

    public static DomainException preconditionFailed(String message) {
        return new DomainException("Precondition Failed: " + message);
    }

    public static DomainException serviceUnavailable(String message) {
        return new DomainException("Service Unavailable: " + message);
    }

    public static DomainException duplicateName(String message) {
        return new DomainException("Duplicate: " + message);
    }
}

