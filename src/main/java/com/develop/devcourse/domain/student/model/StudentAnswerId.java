package com.develop.devcourse.domain.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class StudentAnswerId implements Serializable {

    @Column(name = "user_id")
    private String userId;

    @Column(name = "question_id")
    private Long questionId;
}
