package com.develop.devcourse.domain.lesson.repository;

import com.develop.devcourse.domain.lesson.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByLessonLessonId(Long lessonId);

    @Query("select q.answer from Question q where q.lesson.lessonId = :lessonId")
    List<String> getCorrectAnswerByLessonId(@Param("lessonId") Long lessonId);

    @Query("select count(*) from Question q where q.lesson.lessonId = :lessonId")
    int countQuestionByLessonId(@Param("lessonId") Long lessonId);
}
