package com.develop.devcourse.domain.security.repository;

import com.develop.devcourse.domain.security.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, String> {

    Optional<Users> findByEmail(String email);

    boolean existsByEmail(String email);

}
