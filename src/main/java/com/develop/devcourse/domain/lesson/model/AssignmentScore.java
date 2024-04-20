package com.develop.devcourse.domain.lesson.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assignment_score")
public class AssignmentScore {

    @EmbeddedId
    private AssignmentScoreId assignmentScoreId;

    @Column(name = "score")
    private float score;
}
