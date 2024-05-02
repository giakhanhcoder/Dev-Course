package com.develop.devcourse.domain.course.repository;

import com.develop.devcourse.domain.course.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
    List<Section> findByCourseCourseId(String courseId);
}
