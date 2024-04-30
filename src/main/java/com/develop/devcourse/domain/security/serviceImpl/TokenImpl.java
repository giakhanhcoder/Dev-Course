package com.develop.devcourse.domain.security.serviceImpl;

import com.develop.devcourse.domain.security.jwt.JwtProvider;
import com.develop.devcourse.domain.security.model.Token;
import com.develop.devcourse.domain.security.model.Users;
import com.develop.devcourse.domain.security.repository.TokenRepository;
import com.develop.devcourse.domain.security.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenImpl implements TokenService {

    @Value("${jwt.expired.refresh-token}")
    private Long refreshTokenDurationMs;

    private final JwtProvider jwtProvider;

    private final TokenRepository refreshTokenRepository;



    @Override
    public Optional<Token> findByToken(String refreshToken) {
        return refreshTokenRepository.findByToken(refreshToken);
    }

    @Override
    public Token addToken(Users user, String token, boolean isMobileDevice) {
        return null;
    }


}
