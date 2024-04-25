package com.develop.devcourse.domain.student.service;

import com.develop.devcourse.domain.lesson.dto.request.AnswerRequest;
import com.develop.devcourse.domain.student.exception.StuentException;
import com.develop.devcourse.domain.student.model.StudentAnswer;

import java.util.List;

public interface StudentAnswerService {
    List<StudentAnswer> save(List<AnswerRequest> answerRequests) throws StuentException;
}
