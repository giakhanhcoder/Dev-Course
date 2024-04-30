package com.develop.devcourse.domain.security.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefreshTokenDto {

    @NotBlank
    private String refreshToken;
}
