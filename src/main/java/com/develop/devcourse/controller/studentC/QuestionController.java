package com.develop.devcourse.controller.studentC;

import com.develop.devcourse.domain.lesson.dto.response.QuestionResponse;
import com.develop.devcourse.domain.lesson.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
//@PreAuthorize("hasAuthority('ROLE_STUDENT')")
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/questions")
    public ResponseEntity<List<QuestionResponse>> getAllQuestion() {
        return ResponseEntity.ok(questionService.findAllQuestions());
    }

    @GetMapping("/questions/{id}")
    public ResponseEntity<QuestionResponse> getQuestionById(@PathVariable Long id){
        return ResponseEntity.ok(questionService.findById(id));
    }

    @GetMapping("/lesson-questions/{lessonId}")
    public ResponseEntity<List<QuestionResponse>> getQuestionByLesson(@PathVariable Long lessonId){
        return ResponseEntity.ok(questionService.findAllByLessonLessonId(lessonId));
    }
}
