package com.develop.devcourse.domain.student.repository;

import com.develop.devcourse.domain.student.model.StudentAnswer;
import com.develop.devcourse.domain.student.model.StudentAnswerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentAnswerRepository extends JpaRepository<StudentAnswer, StudentAnswerId> {

    @Query("select sa.studentAnswer from StudentAnswer sa " +
            "where sa.question.lesson.lessonId = :lessonId " +
            "and sa.studentAnswerId.userId = :userId")
    List<String> getStudentAnswerByLessonId(@Param("lessonId") Long lessonId, @Param("userId") String userId);


}
