package com.develop.devcourse.domain.course.repository;

import com.develop.devcourse.domain.course.model.Course;
import com.develop.devcourse.domain.mentor.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    List<Course> findAllByCourseNameContainingOrCourseDesContaining(String courseName, String courseDes);

    Course findByCourseId(String courseId);

    List<Course> findAllByMentor(Mentor mentor);

    Course findByMentorAndCourseId(Mentor mentor, String courseId);
}
