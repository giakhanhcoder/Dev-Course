package com.develop.devcourse.domain.course.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseRequest {

    @NotNull
    private String courseName;

    @NotNull
    private String courseDes;

    @NotNull
    private Integer duration;

    private String imageCourseUrl;

    private boolean isActive;

    @NotNull
    private String courseTitle;

    @NotNull
    private Long coursePrice;

    private Long categoryId;

}
