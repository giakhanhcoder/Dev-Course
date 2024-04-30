package com.develop.devcourse.domain.security.serviceImpl;

import com.develop.devcourse.common.exeption.DomainException;
import com.develop.devcourse.domain.security.model.User;
import com.develop.devcourse.domain.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> DomainException.notFound("User with email: " + email + " !"));

        return UserDetailsImpl.build(user);
    }
}
