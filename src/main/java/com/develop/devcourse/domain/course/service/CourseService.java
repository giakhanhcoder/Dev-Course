package com.develop.devcourse.domain.course.service;

import com.develop.devcourse.common.util.PageResponseDto;
import com.develop.devcourse.domain.course.dto.request.CourseRequest;
import com.develop.devcourse.domain.course.dto.response.CourseResponse;
import com.develop.devcourse.domain.security.dto.response.MessageResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CourseService {

    PageResponseDto<CourseResponse> findAllCourse(Pageable pageable);

    List<CourseResponse> findAllByCourseNameOrDescription(String keyword);

    CourseResponse findCourseById(String courseId);

    MessageResponse postCourse(CourseRequest courseRequest);

    MessageResponse updateCourse(CourseRequest courseRequest, String courseId);

    MessageResponse deleteCourseById(String courseId);

    List<CourseResponse> findAllByMentorId();
}
