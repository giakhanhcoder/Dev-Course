package com.develop.devcourse.domain.lesson.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class AssignmentScoreId implements Serializable {

    @Column(name = "user_id")
    private String userId;

    @Column(name = "lesson_id")
    private Long lessonId;
}
