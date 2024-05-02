package com.develop.devcourse.domain.lesson.service;


import com.develop.devcourse.domain.lesson.dto.request.CommentRequest;
import com.develop.devcourse.domain.lesson.dto.response.CommentResponse;
import com.develop.devcourse.domain.security.dto.response.MessageResponse;

import java.util.List;

public interface CommentService {

    CommentResponse findCommentById(Long commentId) throws Exception;

    List<CommentResponse> findAllCommentByLessonId(Long lessonId) throws Exception;

    void editCommentById(CommentRequest commentRequest, Long commentId) throws Exception;

    void deleteComment(Long commentId) throws Exception;

    MessageResponse postComment(CommentRequest commentRequest, Long lessonId) throws Exception;
}
