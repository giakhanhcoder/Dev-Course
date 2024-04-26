package com.develop.devcourse.domain.student.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_course")
public class StudentCourse {

    @EmbeddedId
    private StudentCourseId studentCourseId;

    @Column(name = "course_score")
    private Integer courseScore;

    @Column(name = "register_date")
    private Date registerDate;

//    @ManyToOne
//    @MapsId("courseId")
//    @JoinColumn(name = "course_id")
//    @JsonIgnore
//    private Course course;

//    @ManyToOne
//    @MapsId("userId")
//    @JoinColumn(name = "user_id")
//    @JsonIgnore
//    private Student student;
}
