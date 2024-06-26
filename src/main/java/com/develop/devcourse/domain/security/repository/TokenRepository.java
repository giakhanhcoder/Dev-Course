package com.develop.devcourse.domain.security.repository;

import com.develop.devcourse.domain.security.model.Token;
import com.develop.devcourse.domain.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findByToken(String token);

    List<Token> findByUser(User user);

    Token findByRefreshToken(String refreshToken);
}


