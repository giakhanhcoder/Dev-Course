package com.develop.devcourse.common.advice;


import com.vn.ssl_be.domain.security.dto.response.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageResponse handlerValidateSignUpForm(MethodArgumentNotValidException e) {
        MessageResponse messageResponse = new MessageResponse();
        // xử lí lỗi
        Map<String, String> map = new HashMap<>();
        e.getBindingResult().getFieldErrors()
                .forEach(err -> map.put(err.getField(), err.getDefaultMessage())
                );

        return new MessageResponse(HttpStatus.BAD_REQUEST, e.getMessage(), map);
    }
}
