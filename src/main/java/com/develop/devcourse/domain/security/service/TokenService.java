package com.develop.devcourse.domain.security.service;

import com.develop.devcourse.domain.security.model.Token;
import com.develop.devcourse.domain.security.model.User;

import java.util.Optional;

public interface TokenService {

    // Optional are a way to handle the case where a method cannot return a value(null)
    // We can use isPresent() to check if the value exists or not
    // or orElse() to provide a default value in case the value is not found
    Optional<Token> findByToken(String refreshToken);

    Token addToken(User user, String token, boolean isMobileDevice);

    Token refreshToken(String refreshToken, User user) throws Exception;

}
