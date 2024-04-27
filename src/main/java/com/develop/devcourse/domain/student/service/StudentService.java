package com.develop.devcourse.domain.student.service;

import com.develop.devcourse.domain.security.model.Users;
import com.develop.devcourse.domain.student.dto.request.StudentRequest;
import com.develop.devcourse.domain.student.dto.response.StudentResponse;
import com.develop.devcourse.domain.student.exception.StudentException;
import com.develop.devcourse.domain.student.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Users user);
    void save(Student student);
    List<StudentResponse> findAll();
    StudentResponse findById(String userId) throws StudentException;
    StudentResponse getStudentProfile();
    StudentResponse updateStudentProfile(StudentRequest studentRequest);
    void deleteById(String userId);
}
