package com.develop.devcourse.domain.course.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SectionResponse {

    private Long sectionId;
    private String sectionName;
    private String courseId;

}
