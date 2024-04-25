package com.develop.devcourse.domain.student.repository;

import com.develop.devcourse.domain.student.model.Student;
import com.develop.devcourse.domain.student.model.StudentAnswer;
import com.develop.devcourse.domain.student.model.StudentAnswerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentAnswerRepository extends JpaRepository<StudentAnswer, StudentAnswerId> {
}
