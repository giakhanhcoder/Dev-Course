package com.develop.devcourse.domain.mentor.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MentorResponse {

    private String userId;
    private String degree;
    private int experience;
}
