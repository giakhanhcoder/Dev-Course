package com.develop.devcourse.domain.security.service;

import com.develop.devcourse.domain.security.model.Token;
import com.develop.devcourse.domain.security.model.Users;

import java.util.Optional;

public interface TokenService {

    // Optional are a way to handle the case where a method cannot return a value(null)
    // We can use isPresent() to check if the value exists or not
    // or orElse() to provide a default value in case the value is not found
    Optional<Token> findByToken(String refreshToken);

    Token addToken(Users user, String token, boolean isMobileDevice);


}
