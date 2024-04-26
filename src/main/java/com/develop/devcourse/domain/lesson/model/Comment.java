package com.develop.devcourse.domain.lesson.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
}
