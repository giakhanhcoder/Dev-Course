package com.develop.devcourse.domain.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentAnswerId implements Serializable {

    @Column(name = "user_id")
    private String userId;

    @Column(name = "question_id")
    private Long questionId;
}
