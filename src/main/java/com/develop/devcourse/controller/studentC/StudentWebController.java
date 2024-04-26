package com.develop.devcourse.controller.studentC;

import com.develop.devcourse.domain.student.dto.request.StudentRequest;
import com.develop.devcourse.domain.student.dto.response.StudentResponse;
import com.develop.devcourse.domain.student.service.StudentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/student")
public class StudentWebController {
    private final StudentService studentService;

    @GetMapping("/profile")
    public ResponseEntity<StudentResponse> getStudentProfile(){
        return new ResponseEntity<>(studentService.getStudentProfile(), HttpStatus.OK);
    }

    @PutMapping("/profile")
    public ResponseEntity<StudentResponse> updateStudentProfile(@ModelAttribute StudentRequest studentRequest){
        return new ResponseEntity<>(studentService.updateStudentProfile(studentRequest),HttpStatus.OK);
    }
}
