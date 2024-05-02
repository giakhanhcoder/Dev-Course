package com.develop.devcourse.controller.studentC;

import com.develop.devcourse.domain.course.dto.response.CourseResponse;
import com.develop.devcourse.domain.lesson.dto.request.AnswerRequest;
import com.develop.devcourse.domain.lesson.dto.response.LessonResponse;
import com.develop.devcourse.domain.lesson.service.LessonService;
import com.develop.devcourse.domain.student.dto.response.StudentCourseResponse;
import com.develop.devcourse.domain.student.service.StudentAnswerService;
import com.develop.devcourse.domain.student.service.StudentCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
//@PreAuthorize("hasAnyAuthority('ROLE_STUDENT')")
public class StudentAnswerController {
    private final StudentCourseService studentCourseService;
    private final StudentAnswerService studentAnswerService;
    private final LessonService lessonService;

    @PostMapping("/answer")
    public ResponseEntity<String> handlePostAnswer(@RequestBody List<AnswerRequest> answerRequests){
        studentAnswerService.save(answerRequests);
        return new ResponseEntity<>("You have answered the question. ", HttpStatus.OK);
    }

    @GetMapping("/student-answer/{lessonId}")
    public ResponseEntity<List<String>> getStudentAnswerByLessonId(@PathVariable Long lessonId){
        return ResponseEntity.ok(studentAnswerService.getStudentAnswerByLessonId(lessonId));
    }

    @GetMapping("/score/{lessonId}")
    public ResponseEntity<Double> calculateScoreOfLesson(@PathVariable Long lessonId){
        return ResponseEntity.ok(studentAnswerService.calculateScoreOfLesson(lessonId));
    }

    @GetMapping("/lesson/{courseId}")
    public ResponseEntity<List<LessonResponse>> getLessonByCourseId(@PathVariable String courseId){
        return ResponseEntity.ok(lessonService.getAllLessonByCourseId(courseId));
    }

    @GetMapping("/course")
    public ResponseEntity<List<StudentCourseResponse>> getAllCourseByUser(){
        return ResponseEntity.ok(studentCourseService.getStudentCourse());
    }
}
