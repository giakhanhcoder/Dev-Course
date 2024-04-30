package com.develop.devcourse.domain.security.service;

import com.develop.devcourse.domain.security.dto.request.ChangePasswordRequest;
import com.develop.devcourse.domain.security.model.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {

    Users findById(String userId);

    Users findByEmail(String email);

    Boolean existsByEmail(String email);

    void changePassword(ChangePasswordRequest changePasswordRequest);

    Users getUserDetailsFromRefreshToken(String token) throws Exception;

    Users getUserDetailFromToken(String token) throws Exception;
}
