package com.develop.devcourse.domain.security.servicesImpl;

import com.develop.devcourse.common.exeption.DomainException;
import com.develop.devcourse.domain.security.model.Users;
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
        Users user = userRepository.findByEmail(email)
                .orElseThrow(() -> DomainException.notFound("User with email: " + email + " !"));

        return UserDetailsImpl.build(user);
    }
}
