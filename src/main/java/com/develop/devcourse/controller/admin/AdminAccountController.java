package com.develop.devcourse.controller.admin;

import com.develop.devcourse.domain.student.dto.response.StudentResponse;
import com.develop.devcourse.domain.student.model.Student;
import com.develop.devcourse.domain.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
public class AdminAccountController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentResponse>> findAllStudent(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<StudentResponse> findStudentById(@PathVariable String userId){
        return ResponseEntity.ok(studentService.findById(userId));
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<String> toggleStudentStatusById(@PathVariable String userId){
        return ResponseEntity.ok("Account status changed successfully");
    }
}
