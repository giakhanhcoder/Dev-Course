package com.develop.devcourse.domain.student.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String address;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthday;
    private String gender;
    private MultipartFile avatarUrl;
    private String phoneNumber;
}
