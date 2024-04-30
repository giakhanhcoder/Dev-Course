package com.develop.devcourse.domain.security.serviceImpl;

import com.develop.devcourse.domain.security.jwt.JwtProvider;
import com.develop.devcourse.domain.security.model.Token;
import com.develop.devcourse.domain.security.model.User;
import com.develop.devcourse.domain.security.repository.TokenRepository;
import com.develop.devcourse.domain.security.service.TokenService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenImpl implements TokenService {

    @Value("${jwt.expired.refresh-token}")
    private Long expirationRefreshToken;

    @Value("${jwt.expired.access-token}")
    private Long expiration;

    private final JwtProvider jwtProvider;

    private final TokenRepository tokenRepository;

    private static final int MAX_TOKENS = 3;

    @Override
    public Optional<Token> findByToken(String refreshToken)
    {
        return tokenRepository.findByToken(refreshToken);
    }

    @Override
    public Token addToken(User user, String token, boolean isMobileDevice) {
        List<Token> userTokens = tokenRepository.findByUser(user);
        int tokenCount = userTokens.size();
        // Số lượng token vượt quá giới hạn, xóa một token cũ
        if(tokenCount >= MAX_TOKENS){
            // kiểm tra xem trong danh sách userTokens có tồn tại ít nhất
            // một token không phải là thiết bị di động (non-mobile)
            boolean hasNonMobileToken = !userTokens.stream().allMatch(Token::isMobile);
            Token tokenToDelete;
            if(hasNonMobileToken){
                tokenToDelete = userTokens.stream()
                        .filter(userToken -> !userToken.isMobile())
                        .findFirst()
                        .orElse(userTokens.getFirst());
            }else{
                // tất cả các token đều là thiết bị di động
                // chúng ta sẽ xóa token đầu tiên trong danh sách
                tokenToDelete = userTokens.getFirst();
            }
            tokenRepository.delete(tokenToDelete);
        }
        long expirationInSeconds = expiration;
        LocalDateTime expirationDateTime = LocalDateTime.now().plusSeconds(expirationInSeconds);

        // Tạo mới một token cho người dùng
        Token newToken = Token.builder()
                .user(user)
                .token(token)
                .revoked(false)
                .expired(false)
                .tokenType("Bearer")
                .expirationDate(expirationDateTime)
                .isMobile(isMobileDevice)
                .build();

        newToken.setRefreshToken(UUID.randomUUID().toString());
        newToken.setRefreshExpirationDate(LocalDateTime.now().plusSeconds(expirationRefreshToken));
        tokenRepository.save(newToken);
        return newToken;
    }

    @Transactional
    @Override
    public Token refreshToken(String refreshToken, User user) throws Exception {
        Token existingToken = tokenRepository.findByRefreshToken(refreshToken);
        if(existingToken == null){
            throw new Exception("Refresh token dose not exist");
        }
        if(existingToken.getRefreshExpirationDate().compareTo(LocalDateTime.now()) < 0){
                tokenRepository.delete(existingToken);
                throw new Exception("Refresh token is expired");
        }
        String token = jwtProvider.generateTokenFromEmail(user.getEmail());
        LocalDateTime exLocalDateTime = LocalDateTime.now().plusSeconds(expiration);
        existingToken.setExpirationDate(exLocalDateTime);
        existingToken.setToken(token);
        existingToken.setRefreshToken(UUID.randomUUID().toString());
        existingToken.setRefreshExpirationDate(LocalDateTime.now().plusSeconds(expirationRefreshToken));
        tokenRepository.save(existingToken);
        return existingToken;
    }


}
