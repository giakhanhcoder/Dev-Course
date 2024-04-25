package com.develop.devcourse.domain.lesson.repository;

import com.develop.devcourse.domain.lesson.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByLessonLessonId(Long lessonId);

}
