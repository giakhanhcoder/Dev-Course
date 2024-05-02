package com.develop.devcourse.controller.studentC;


import com.develop.devcourse.domain.lesson.dto.request.CommentRequest;
import com.develop.devcourse.domain.lesson.dto.response.CommentResponse;
import com.develop.devcourse.domain.lesson.service.CommentService;
import com.develop.devcourse.domain.security.dto.response.MessageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student/comment")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/lesson/{lessonId}")
    public ResponseEntity<List<CommentResponse>> getAllCommentByLessonId(@PathVariable(value = "lessonId") Long lessonId)
            throws Exception {
        return ResponseEntity.ok(commentService.findAllCommentByLessonId(lessonId));
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentResponse> getCommentByCommentId(@PathVariable(value = "commentId") Long commentId)
            throws Exception {
        return ResponseEntity.ok(commentService.findCommentById(commentId));
    }

    @PostMapping("/{lessonId}")
    public ResponseEntity<MessageResponse> postCommentToLessonId(@PathVariable(value = "lessonId") Long lessonId,
                                                                 @Valid @RequestBody CommentRequest commentRequest)
            throws Exception {
        return ResponseEntity.ok(commentService.postComment(commentRequest, lessonId));
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<String> updateCommentByCommentId(@PathVariable Long commentId,
                                                        @RequestBody CommentRequest commentRequest)
            throws Exception {
        commentService.editCommentById(commentRequest, commentId);
        return ResponseEntity.ok("Update comment successfully");
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteCommentByCommentId(@PathVariable Long commentId)
            throws Exception {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok("Delete comment successfully");
    }
}
