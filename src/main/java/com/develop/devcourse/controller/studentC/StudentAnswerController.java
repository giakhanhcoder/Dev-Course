package com.develop.devcourse.controller.studentC;

import com.develop.devcourse.domain.lesson.dto.request.AnswerRequest;
import com.develop.devcourse.domain.student.service.StudentAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
@PreAuthorize("hasAnyAuthority('ROLE_STUDENT')")
public class StudentAnswerController {

    private final StudentAnswerService studentAnswerService;

    @PostMapping("/answer")
    public ResponseEntity<List<com.develop.devcourse.domain.student.model.StudentAnswer>> handlePostAnswer(@RequestBody List<AnswerRequest> answerRequests){
//        List<StudentAnswer> saveStudentAnswers = studentAnswerService.save(answerRequests);
        return new ResponseEntity<>(studentAnswerService.save(answerRequests), HttpStatus.OK);
    }
}
