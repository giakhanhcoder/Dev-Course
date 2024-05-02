package com.develop.devcourse.domain.student.service;

import com.develop.devcourse.domain.course.dto.response.CourseResponse;
import com.develop.devcourse.domain.student.dto.response.StudentCourseResponse;

import java.util.List;

public interface StudentCourseService {
    List<StudentCourseResponse> getStudentCourse();
}
