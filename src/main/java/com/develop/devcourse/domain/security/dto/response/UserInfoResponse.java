package com.develop.devcourse.domain.security.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponse {
    private String id;
    private String email;
    private String fullName;
    private String accessToken;
    private String refreshToken;
    private List<String> roles;
    private Instant expiryDate;
    private String image;
    private String tokenType;
    private Long budget;
}
