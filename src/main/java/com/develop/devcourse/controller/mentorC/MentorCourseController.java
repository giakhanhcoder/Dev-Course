package com.develop.devcourse.controller.mentorC;

import com.develop.devcourse.domain.course.dto.request.CourseRequest;
import com.develop.devcourse.domain.course.dto.response.CourseResponse;
import com.develop.devcourse.domain.course.service.CourseService;
import com.develop.devcourse.domain.security.dto.response.MessageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mentor/courses")
public class MentorCourseController {

    private final CourseService courseService;

    //    @PreAuthorize("hasAuthority('ROLE_MENTOR')") or check mentor == null all are okay.
    @PostMapping
    public ResponseEntity<MessageResponse> postCourse(@Valid @RequestBody CourseRequest courseRequest){
        return ResponseEntity.ok(courseService.postCourse(courseRequest));
    }

    @PutMapping({"/{courseId}"})
    public ResponseEntity<MessageResponse> updateCourseById(@Valid @RequestBody CourseRequest courseRequest,@PathVariable String courseId){
        return ResponseEntity.ok(courseService.updateCourse(courseRequest, courseId));
    }

    @DeleteMapping({"/{courseId}"})
    public ResponseEntity<MessageResponse> deleteCourseById(@PathVariable String courseId){
        return ResponseEntity.ok(courseService.deleteCourseById(courseId));
    }

    @GetMapping
    public ResponseEntity<List<CourseResponse>> getAllCourseByMentor(){
        return ResponseEntity.ok(courseService.findAllByMentorId());
    }
}
