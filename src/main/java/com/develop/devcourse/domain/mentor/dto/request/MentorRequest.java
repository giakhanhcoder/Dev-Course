package com.develop.devcourse.domain.mentor.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MentorRequest {

    @NotBlank
    private String degree;

    private int experience;
}
