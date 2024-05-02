package com.develop.devcourse.domain.lesson.serviceImpl;

import com.develop.devcourse.domain.lesson.dto.request.CommentRequest;
import com.develop.devcourse.domain.lesson.dto.response.CommentResponse;
import com.develop.devcourse.domain.lesson.exception.CommentException;
import com.develop.devcourse.domain.lesson.model.Comment;
import com.develop.devcourse.domain.lesson.model.Lesson;
import com.develop.devcourse.domain.lesson.repository.CommentRepository;
import com.develop.devcourse.domain.lesson.repository.LessonRepository;
import com.develop.devcourse.domain.lesson.service.CommentService;
import com.develop.devcourse.domain.security.dto.response.MessageResponse;
import com.develop.devcourse.domain.security.model.User;
import com.develop.devcourse.domain.security.repository.UserRepository;
import com.develop.devcourse.domain.security.serviceImpl.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final LessonRepository lessonRepository;

    @Override
    public CommentResponse findCommentById(Long commentId) throws Exception {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByEmail(userDetails.getEmail()).orElseThrow();
        Comment comment = commentRepository.findByCommentIdAndUser(commentId, user);
        if (comment == null) {
            throw new CommentException("Not found that comment");
        } else {
            CommentResponse commentResponse = modelMapper.map(comment, CommentResponse.class);
            commentResponse.setLessonId(comment.getLesson().getLessonId());
            return commentResponse;
        }
    }

    @Override
    public List<CommentResponse> findAllCommentByLessonId(Long lessonId) throws Exception {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByEmail(userDetails.getEmail()).orElseThrow();
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow();
        List<Comment> commentList = commentRepository.findAllByLessonAndUser(lesson, user);
        if (commentList.isEmpty()) {
            throw new CommentException("Not found comments from lesson");
        } else {
            List<CommentResponse> commentResponse = commentList.stream().map(comment -> {
                CommentResponse response = modelMapper.map(comment, CommentResponse.class);
                response.setLessonId(comment.getLesson().getLessonId());
                return response;
            }).collect(Collectors.toList());
            return commentResponse;
        }
    }

    @Override
    public void editCommentById(CommentRequest commentRequest, Long commentId) throws Exception {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByEmail(userDetails.getEmail()).orElseThrow();
        Comment comment = commentRepository.findByCommentIdAndUser(commentId, user);
        if (comment == null) {
            throw new CommentException("Not found that comment");
        } else {
            comment.setCommentBody(commentRequest.getCommentBody());
            commentRepository.save(comment);
        }
    }

    @Override
    public void deleteComment(Long commentId) throws Exception {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByEmail(userDetails.getEmail()).orElseThrow();
        Comment comment = commentRepository.findByCommentIdAndUser(commentId, user);
        if (comment == null) {
            throw new CommentException("Not found that comment");
        } else {
            commentRepository.delete(comment);
        }
    }

    @Override
    public MessageResponse postComment(CommentRequest commentRequest, Long lessonId) throws Exception {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByEmail(userDetails.getEmail()).orElse(null);
        Lesson lesson = lessonRepository.findById(lessonId).orElse(null);
        if(user == null || lesson == null){
            throw new CommentException("User or lesson are not found");
        }
        Comment newComment = Comment.builder()
                .commentBody(commentRequest.getCommentBody())
                .lesson(lesson)
                .user(user)
                .build();
        commentRepository.save(newComment);

        return MessageResponse.builder()
                .httpStatus(HttpStatus.CREATED)
                .message("Upload comment successfully")
                .build();
    }
}
