package com.develop.devcourse.domain.student.repository;

import com.develop.devcourse.domain.student.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, String> {
}
