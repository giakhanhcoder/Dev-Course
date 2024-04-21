package com.develop.devcourse.domain.security.dto.response;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageResponse {
    private HttpStatus httpStatus;
    private String message;
    private Map<String, String> validateMessage;
}