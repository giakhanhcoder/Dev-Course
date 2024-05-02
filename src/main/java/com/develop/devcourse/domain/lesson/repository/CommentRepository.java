package com.develop.devcourse.domain.lesson.repository;

import com.develop.devcourse.domain.lesson.model.Comment;
import com.develop.devcourse.domain.lesson.model.Lesson;
import com.develop.devcourse.domain.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment findByCommentIdAndUser(Long commentId, User user);

    List<Comment> findAllByLessonAndUser(Lesson lesson, User user);
}
