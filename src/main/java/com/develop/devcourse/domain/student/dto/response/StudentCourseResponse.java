package com.develop.devcourse.domain.student.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCourseResponse {
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date registerDate;
    private String categoryName;
}
