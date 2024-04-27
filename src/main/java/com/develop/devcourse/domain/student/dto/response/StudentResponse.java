package com.develop.devcourse.domain.student.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private String userId;
    private String address;
    private Date birthday;
    private String email;
    private String firstName;
    private String lastName;
    private Boolean gender;
    private String avatarUrl;
    private String phoneNumber;
}
