package com.develop.devcourse.domain.security.dto.response;


import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfoResponse {
    private String id;
    private String email;
    private String fullName;
    private String accessToken;
    private String refreshToken;
    private List<String> roles;
    private LocalDateTime expiryDate;
    private String image;
    private String tokenType;
    private Long budget;
}
