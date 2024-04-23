package com.develop.devcourse.domain.student.service;

import com.develop.devcourse.domain.security.model.Users;
import com.develop.devcourse.domain.student.model.Student;

public interface StudentService {
    Student createStudent(Users user);

    void save(Student student);
}
