package com.develop.devcourse.domain.lesson.repository;

import com.develop.devcourse.domain.lesson.model.AssignmentScore;
import com.develop.devcourse.domain.lesson.model.AssignmentScoreId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentScoreRepository extends JpaRepository<AssignmentScore, AssignmentScoreId> {
}
