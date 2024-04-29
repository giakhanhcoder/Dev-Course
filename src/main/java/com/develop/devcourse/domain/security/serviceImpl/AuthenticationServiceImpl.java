package com.develop.devcourse.domain.security.serviceImpl;

import com.develop.devcourse.domain.security.dto.request.LoginRequest;
import com.develop.devcourse.domain.security.dto.request.SignupRequest;
import com.develop.devcourse.domain.security.dto.response.MessageResponse;
import com.develop.devcourse.domain.security.dto.response.UserInfoResponse;
import com.develop.devcourse.domain.security.exeption.LoginFailException;
import com.develop.devcourse.domain.security.jwt.JwtProvider;
import com.develop.devcourse.domain.security.model.RefreshToken;
import com.develop.devcourse.domain.security.model.Role;
import com.develop.devcourse.domain.security.model.RoleName;
import com.develop.devcourse.domain.security.model.Users;
import com.develop.devcourse.domain.security.service.AuthenticationService;
import com.develop.devcourse.domain.security.service.RefreshTokenService;
import com.develop.devcourse.domain.security.service.RoleServices;
import com.develop.devcourse.domain.security.service.UserService;
import com.develop.devcourse.domain.student.model.Student;
import com.develop.devcourse.domain.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtProvider jwtProvider;

    private final RoleServices roleServices;

    private final StudentService studentService;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    private final RefreshTokenService refreshTokenService;


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
        user.setUpdateAt(new Date());
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

    @Override
    public UserInfoResponse handleAuthenticateUser(LoginRequest loginRequest) {
        try {
            // when call authenticationManager.authenticate()
            // AuthenticationManager will access all AuthenticationProviders
            // =>  DaoAuthenticationProvider use UserDetailsService to check user in the database
            // check with user login does it match with the user in the database
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );
        }catch (AuthenticationException e){
            throw new LoginFailException("Email or password incorrect !");
        }

        Users user = userService.findByEmail(loginRequest.getEmail());

        RefreshToken refreshToken = refreshTokenService.createRefreshToken(user);

        String accessToken = jwtProvider.generateTokenFromEmail(loginRequest.getEmail());

        List<String> roles = user.getRoles()
                .stream()
                .map(role -> role.getRoleName().name())
                .toList();

        return UserInfoResponse.builder()
                .id(user.getUserId())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .accessToken(accessToken)
                .refreshToken(refreshToken.getToken())
                .expiryDate(refreshToken.getExpiryDate())
                .roles(roles)
                .image(user.getAvatarUrl())
                .tokenType("Bearer")
                .budget(user.getBudget())
                .build();
    }
}
