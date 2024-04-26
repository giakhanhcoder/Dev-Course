package com.develop.devcourse.domain.lesson.service;

import com.develop.devcourse.domain.lesson.dto.request.QuestionRequest;
import com.develop.devcourse.domain.lesson.dto.response.QuestionResponse;
import com.develop.devcourse.domain.lesson.exception.LessonException;
import com.develop.devcourse.domain.lesson.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAll();

    List<QuestionResponse> findAllQuestions();

    QuestionResponse findById(Long id) throws LessonException;
    // For Mentor and Admin
    Question save(QuestionRequest questionRequest);
    // For Mentor and Admin
    void deleteById(Long id);

    List<QuestionResponse> findAllByLessonLessonId(Long lessonId);
}
