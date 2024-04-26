package com.develop.devcourse.controller.permitAll;

import com.develop.devcourse.domain.security.dto.request.LoginRequest;
import com.develop.devcourse.domain.security.dto.request.SignupRequest;
import com.develop.devcourse.domain.security.dto.response.MessageResponse;
import com.develop.devcourse.domain.security.dto.response.UserInfoResponse;
import com.develop.devcourse.domain.security.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthenticationService authenticationService;


    @PostMapping("/sign-up")
    public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        return ResponseEntity.ok()
                .body(authenticationService.handleRegisterUser(signupRequest));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<UserInfoResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(authenticationService.handleAuthenticateUser(loginRequest), HttpStatus.OK);
    }
}
