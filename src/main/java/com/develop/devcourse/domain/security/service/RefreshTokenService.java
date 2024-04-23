package com.develop.devcourse.domain.security.service;

import com.develop.devcourse.domain.security.model.RefreshToken;
import com.develop.devcourse.domain.security.model.Users;

public interface RefreshTokenService {
    RefreshToken createRefreshToken(Users users);
}
