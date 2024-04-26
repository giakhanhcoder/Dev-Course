package com.develop.devcourse.domain.security.serviceImpl;

import com.develop.devcourse.common.exeption.DomainException;
import com.develop.devcourse.domain.security.exeption.UserException;
import com.develop.devcourse.domain.security.model.Users;
import com.develop.devcourse.domain.security.repository.UserRepository;
import com.develop.devcourse.domain.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


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


}
