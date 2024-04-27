package com.develop.devcourse.domain.security.serviceImpl;

import com.develop.devcourse.domain.security.jwt.JwtProvider;
import com.develop.devcourse.domain.security.model.RefreshToken;
import com.develop.devcourse.domain.security.model.Users;
import com.develop.devcourse.domain.security.repository.RefreshTokenRepository;
import com.develop.devcourse.domain.security.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class RefreshTokenImpl implements RefreshTokenService {

    @Value("${jwt.expired.refresh-token}")
    private Long refreshTokenDurationMs;

    private final JwtProvider jwtProvider;

    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public RefreshToken createRefreshToken(Users users) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUser(users);
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(jwtProvider.generateRefreshToken(users.getEmail()));
//        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken = refreshTokenRepository.save(refreshToken);

        return refreshToken;
    }
}
