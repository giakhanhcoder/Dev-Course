package com.develop.devcourse.controller.studentC;

import com.develop.devcourse.domain.lesson.dto.request.AnswerRequest;
import com.develop.devcourse.domain.student.service.StudentAnswerService;
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

    private final StudentAnswerService studentAnswerService;

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
}
