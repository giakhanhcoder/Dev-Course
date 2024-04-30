package com.develop.devcourse.domain.security.service;

import com.develop.devcourse.domain.security.dto.request.ChangePasswordRequest;
import com.develop.devcourse.domain.security.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {

    User findById(String userId);

    User findByEmail(String email);

    Boolean existsByEmail(String email);

    void changePassword(ChangePasswordRequest changePasswordRequest);

    User getUserDetailsFromRefreshToken(String token) throws Exception;

    User getUserDetailFromToken(String token) throws Exception;
}
