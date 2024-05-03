package com.develop.devcourse.domain.mentor.repository;

import com.develop.devcourse.domain.mentor.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, String> {

    boolean existsByMentorId(String mentorId);
}
