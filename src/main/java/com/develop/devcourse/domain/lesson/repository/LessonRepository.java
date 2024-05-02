package com.develop.devcourse.domain.lesson.repository;

import com.develop.devcourse.domain.lesson.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    @Query("select l from Lesson l where l.section.sectionId =:sectionId")
    List<Lesson> findBySectionId(@Param("sectionId") Long sectionId);
}
