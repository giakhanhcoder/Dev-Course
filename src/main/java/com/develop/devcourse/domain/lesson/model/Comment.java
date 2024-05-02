package com.develop.devcourse.domain.lesson.model;

import com.develop.devcourse.domain.security.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "comment_body")
    private String commentBody;

    @ManyToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "lesson_id")
    @JsonIgnore
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonIgnore
    private User user;
}
