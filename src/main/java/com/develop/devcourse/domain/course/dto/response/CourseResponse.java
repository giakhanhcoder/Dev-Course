package com.develop.devcourse.domain.course.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseResponse {

    private String courseId;

    private String courseName;

    private String courseDes;

    private Integer duration;

    private String imageCourseUrl;

    private boolean isActive;

    private String courseTitle;

    private Long coursePrice;

    private int courseRate;

    private String courseFeedback;

    private String categoryName;
}
