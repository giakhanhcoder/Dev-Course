package com.develop.devcourse.domain.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class StudentCourseId implements Serializable {

    @Column(name = "user_id")
    private String userId;

    @Column(name = "course_id")
    private String courseId;
}
