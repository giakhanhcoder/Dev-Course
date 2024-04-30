package com.develop.devcourse.domain.student.service;

import com.develop.devcourse.domain.lesson.dto.request.AnswerRequest;
import com.develop.devcourse.domain.student.exception.StudentException;

import java.util.List;

public interface StudentAnswerService {
    void save(List<AnswerRequest> answerRequests) throws StudentException;

    List<String> getStudentAnswerByLessonId(Long lessonId);

    double calculateScoreOfLesson(Long lessonId);
}
