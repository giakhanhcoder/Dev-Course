package com.develop.devcourse.common.advice;


import com.develop.devcourse.common.exeption.DomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<String> handleDomainException(DomainException ex) {
        HttpStatus status;
        String errorMessage;

        switch (ex.getMessage()) {
            case "Not Found":
                status = HttpStatus.NOT_FOUND;
                errorMessage = "Not Found";
                break;
            case "Bad Request":
                status = HttpStatus.BAD_REQUEST;
                errorMessage = "Bad Request";
                break;
            case "Unauthorized":
                status = HttpStatus.UNAUTHORIZED;
                errorMessage = "Unauthorized";
                break;
            case "Internal Server Error":
                status = HttpStatus.INTERNAL_SERVER_ERROR;
                errorMessage = "Internal Server Error";
                break;
            case "Conflict":
                status = HttpStatus.CONFLICT;
                errorMessage = "Conflict";
                break;
            case "Validation Error":
                status = HttpStatus.UNPROCESSABLE_ENTITY;
                errorMessage = "Validation Error";
                break;
            case "Forbidden":
                status = HttpStatus.FORBIDDEN;
                errorMessage = "Forbidden";
                break;
            case "Method Not Allowed":
                status = HttpStatus.METHOD_NOT_ALLOWED;
                errorMessage = "Method Not Allowed";
                break;
            case "Unsupported Media Type":
                status = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
                errorMessage = "Unsupported Media Type";
                break;
            case "Precondition Failed":
                status = HttpStatus.PRECONDITION_FAILED;
                errorMessage = "Precondition Failed";
                break;
            case "Service Unavailable":
                status = HttpStatus.SERVICE_UNAVAILABLE;
                errorMessage = "Service Unavailable";
                break;
            case "Duplicate":
                status = HttpStatus.IM_USED;
                errorMessage = "Invalid name";
            default:
                status = HttpStatus.INTERNAL_SERVER_ERROR;
                errorMessage = "Internal Server Error";
                break;
        }
        return new ResponseEntity<>(errorMessage + ": " + ex.getMessage(), status);
    }
}

