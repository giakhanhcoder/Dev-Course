package com.develop.devcourse.domain.security.service;

import com.develop.devcourse.domain.security.model.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {

    Users findById(String userId);



}
