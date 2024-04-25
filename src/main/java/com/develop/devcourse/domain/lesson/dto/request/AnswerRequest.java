package com.develop.devcourse.domain.lesson.dto.request;

import com.develop.devcourse.domain.lesson.model.Answer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerRequest {
    private String userId;
    private Long questionId;
    private Answer studentAnswer;
}
