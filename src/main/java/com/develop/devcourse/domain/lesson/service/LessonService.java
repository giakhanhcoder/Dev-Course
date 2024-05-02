package com.develop.devcourse.domain.lesson.service;

import com.develop.devcourse.domain.lesson.dto.request.LessonRequest;
import com.develop.devcourse.domain.lesson.dto.response.LessonResponse;
import com.develop.devcourse.domain.lesson.exception.LessonException;
import com.develop.devcourse.domain.lesson.model.Lesson;

import java.util.List;

public interface LessonService {
    List<Lesson> findAll();
    Lesson findById(Long lessonId) throws LessonException;

    Lesson save(LessonRequest lessonRequest);
    void deleteById(Long lessonId);
    List<LessonResponse> getAllLessonByCourseId(String courseId);
}
