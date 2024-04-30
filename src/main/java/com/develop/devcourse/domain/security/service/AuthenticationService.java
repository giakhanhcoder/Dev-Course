package com.develop.devcourse.domain.security.service;

import com.develop.devcourse.domain.security.dto.request.LoginRequest;
import com.develop.devcourse.domain.security.dto.request.RefreshTokenDto;
import com.develop.devcourse.domain.security.dto.request.SignupRequest;
import com.develop.devcourse.domain.security.dto.response.MessageResponse;
import com.develop.devcourse.domain.security.dto.response.UserInfoResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface AuthenticationService {
        MessageResponse handleRegisterUser(SignupRequest signupRequest);

        UserInfoResponse handleAuthenticateUser(LoginRequest loginRequest,
                                                HttpServletRequest request);


        UserInfoResponse handleRefreshToken(RefreshTokenDto refreshTokenDto) throws Exception;
}
