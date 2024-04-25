package com.develop.devcourse.domain.lesson.dto.response;

import com.develop.devcourse.domain.lesson.model.Answer;
import com.develop.devcourse.domain.lesson.model.Lesson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponse {
    private Long questionId;
    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private Lesson lesson;
    private Answer answer;
}
