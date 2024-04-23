package com.develop.devcourse.domain.security.servicesImpl;

import com.develop.devcourse.domain.security.dto.request.SignupRequest;
import com.develop.devcourse.domain.security.dto.response.MessageResponse;
import com.develop.devcourse.domain.security.model.Role;
import com.develop.devcourse.domain.security.model.RoleName;
import com.develop.devcourse.domain.security.model.Users;
import com.develop.devcourse.domain.security.service.AuthenticationService;
import com.develop.devcourse.domain.security.service.RoleServices;
import com.develop.devcourse.domain.student.model.Student;
import com.develop.devcourse.domain.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

//    private final JwtProvider jwtProvider;

    private final RoleServices roleServices;

    private final StudentService studentService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public MessageResponse handleRegisterUser(SignupRequest signupRequest) {

        Set<Role> roles = new HashSet<>();
        roles.add(roleServices.findRoleByRoleName(RoleName.ROLE_STUDENT));

        Users user = new Users();
        user.setFirstName(signupRequest.getFirstName());
        user.setLastName(signupRequest.getLastName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setCreateAt(new Date());
        user.setActive(true);
        user.setRoles(roles);
        user.setPhoneNumber(signupRequest.getPhoneNumber());
        user.setBirthday(signupRequest.getBirthDate());
        user.setBudget(0L);

        Student student = studentService.createStudent(user);
        studentService.save(student);

        return MessageResponse.builder()
                .httpStatus(HttpStatus.CREATED)
                .message("User registered successfully")
                .build();

    }
}
