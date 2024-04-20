package com.develop.devcourse.domain.student.model;

import com.develop.devcourse.domain.lesson.model.Answer;
import com.develop.devcourse.domain.lesson.model.Question;
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
@Table(name = "student_answer")
public class StudentAnswer {

    @EmbeddedId
    private StudentAnswerId studentAnswerId;

    @Enumerated(EnumType.STRING)
    private Answer studentAnswer;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "s")
    private Student student;
}
