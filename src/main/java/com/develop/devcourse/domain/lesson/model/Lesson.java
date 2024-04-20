package com.develop.devcourse.domain.lesson.model;

import com.develop.devcourse.domain.course.model.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    private Long lessonId;

    @Column(name = "content_link")
    private String contentLink;

    @Column(name = "lesson_title")
    private String lessonTitle;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course;

    @OneToMany(mappedBy = "lesson")
    @JsonIgnore
    private List<Question> questions;

    @OneToMany(mappedBy = "lesson")
    @JsonIgnore
    private List<Comment> comments;

}
