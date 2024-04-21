package com.develop.devcourse.domain.security.dto.request;


import com.develop.devcourse.domain.security.validator.ExistEmail;
import com.develop.devcourse.domain.security.validator.PasswordMatching;
import com.develop.devcourse.domain.security.validator.StrongPassword;
import com.develop.devcourse.domain.security.validator.ValidEmail;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@PasswordMatching(
        password = "password",
        confirmPassword = "confirmPassword",
        message = "Password and Confirm Password must be matched!"
)
public class SignupRequest {

    @NotBlank(message = "Please enter first name")
    private String firstName;

    @NotBlank(message = "Please enter last name")
    private String lastName;

    @ExistEmail
    @ValidEmail
    @NotBlank(message = "Please enter Email")
    private String email;


    @StrongPassword
    @NotBlank(message = "Please enter password")
    private String password;

    @NotBlank(message = "Please enter confirm password")
    private String confirmPassword;
}
