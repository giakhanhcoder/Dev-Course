package com.develop.devcourse.domain.student.servicesImpl;

import com.develop.devcourse.domain.security.model.Users;
import com.develop.devcourse.domain.student.model.Student;
import com.develop.devcourse.domain.student.repository.StudentRepository;
import com.develop.devcourse.domain.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(Users user) {
        Student student = new Student();
        student.setUser(user);
        return student;
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }
}
