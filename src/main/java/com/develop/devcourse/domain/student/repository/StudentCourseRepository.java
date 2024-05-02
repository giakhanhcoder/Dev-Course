package com.develop.devcourse.domain.student.repository;

import com.develop.devcourse.domain.course.model.Course;
import com.develop.devcourse.domain.student.model.StudentCourse;
import com.develop.devcourse.domain.student.model.StudentCourseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, StudentCourseId> {
    @Query("select sc from StudentCourse sc where sc.student.studentId =:userId")
    List<StudentCourse> findAllByStudentId(@Param("userId") String userId);

}
