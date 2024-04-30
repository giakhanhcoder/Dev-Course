package com.develop.devcourse.domain.security.serviceImpl;

import com.develop.devcourse.common.exeption.DomainException;
import com.develop.devcourse.domain.security.dto.request.ChangePasswordRequest;
import com.develop.devcourse.domain.security.exeption.UserException;
import com.develop.devcourse.domain.security.jwt.JwtProvider;
import com.develop.devcourse.domain.security.model.Token;
import com.develop.devcourse.domain.security.model.Users;
import com.develop.devcourse.domain.security.repository.TokenRepository;
import com.develop.devcourse.domain.security.repository.UserRepository;
import com.develop.devcourse.domain.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    private final TokenRepository tokenRepository;

    @Override
    public Users findById(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> UserException.notFound("Could not found Id"));
    }

    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> DomainException.notFound(email));
    }

    @Override
    public Boolean existsByEmail(String email) {
        return null;
    }

    @Override
    public void changePassword(ChangePasswordRequest changePasswordRequest) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Users user = findByEmail(userDetails.getEmail());

        boolean checkOldPassword = passwordEncoder.matches(changePasswordRequest.getOldPassword(), user.getPassword());

        if(!checkOldPassword){
            throw UserException.badRequest("Incorrect old password. Please try again !");
        }else{
            user.setPassword(passwordEncoder.encode(changePasswordRequest.getNewPassword()));
            userRepository.save(user);
        }

    }

    @Override
    public Users getUserDetailsFromRefreshToken(String refreshToken) throws Exception {
        Token existingToken = tokenRepository.findByRefreshToken(refreshToken);

        return getUserDetailFromToken(existingToken.getToken());
    }

    @Override
    public Users getUserDetailFromToken(String token) throws Exception {
        if(jwtProvider.isTokenExpired(token)){
            throw new Exception("Token is expired");
        }
        String subject = jwtProvider.getSubject(token);
        Optional<Users> user;
        user = userRepository.findByEmail(subject);
        return user.orElseThrow(() -> new Exception("User not found"));
    }


}
