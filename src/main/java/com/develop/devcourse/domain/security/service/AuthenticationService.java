package com.develop.devcourse.domain.security.service;

import com.develop.devcourse.domain.security.dto.request.LoginRequest;
import com.develop.devcourse.domain.security.dto.request.SignupRequest;
import com.develop.devcourse.domain.security.dto.response.MessageResponse;
import com.develop.devcourse.domain.security.dto.response.UserInfoResponse;

public interface AuthenticationService {
        MessageResponse handleRegisterUser(SignupRequest signupRequest);

        UserInfoResponse handleAuthenticateUser(LoginRequest loginRequest);



}
