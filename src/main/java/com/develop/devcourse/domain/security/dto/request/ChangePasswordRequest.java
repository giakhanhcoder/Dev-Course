package com.develop.devcourse.domain.security.dto.request;

import com.develop.devcourse.domain.security.validator.PasswordMatching;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PasswordMatching(
        password = "newPassword",
        confirmPassword = "confirmNewPassword",
        message = "New Password and Confirm New Password are not matching!"
)
public class ChangePasswordRequest  {
    @NotBlank(message = "Please enter your Old password")
    private String oldPassword;

    @NotBlank(message = "Please enter your New password")
    private String newPassword;

    @NotBlank(message = "Please enter your Confirm password")
    private String confirmNewPassword;
}
