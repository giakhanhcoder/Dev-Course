package com.develop.devcourse.domain.security.service;

import com.develop.devcourse.domain.security.dto.request.SignupRequest;
import com.develop.devcourse.domain.security.dto.response.MessageResponse;

public interface AuthenticationService {
        MessageResponse handleRegisterUser(SignupRequest signupRequest);
}
