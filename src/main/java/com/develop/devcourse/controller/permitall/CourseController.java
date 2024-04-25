package com.develop.devcourse.controller.permitall;

import com.develop.devcourse.common.util.PageResponseDto;
import com.develop.devcourse.domain.course.dto.response.CourseResponse;
import com.develop.devcourse.domain.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<PageResponseDto<CourseResponse>> getAllCourse(Pageable pageable) {
        return ResponseEntity.ok(courseService.findAllCourse(pageable));
    }

    @GetMapping("/search")
    public ResponseEntity<List<CourseResponse>> getAllCourseByNameOrDescription(@RequestParam("query") String keyword){
        return ResponseEntity.ok(courseService.findAllByCourseNameOrDescription(keyword));
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseResponse> getCourseById(@PathVariable String courseId){
        return ResponseEntity.ok(courseService.findCourseById(courseId));
    }
}
