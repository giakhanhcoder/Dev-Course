package com.develop.devcourse.domain.course.model;

import com.develop.devcourse.domain.lesson.model.Lesson;
import com.develop.devcourse.domain.mentor.model.Mentor;
import com.develop.devcourse.domain.payment.model.OrderCourse;
import com.develop.devcourse.domain.student.model.StudentCourse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "course_id")
    private String courseId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_des")
    private String courseDes;

    @Column(name = "duration")
    private Date duration;

    @Column(name = "image_course_url")
    private String imageCourseUrl;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "course_title")
    private String courseTitle;

    @Column(name = "course_price")
    private Long coursePrice;

    @Column(name = "course_rate")
    private int courseRate;

    @Column(name = "course_feedback")
    private String courseFeedback;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @JsonIgnoreProperties({"categoryName", "description"})
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_id", referencedColumnName = "mentor_id")
    @JsonIgnoreProperties({"degree","experience"})
    private Mentor mentor;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<Lesson> lesson;

    @OneToMany(mappedBy = "course")
    private List<StudentCourse> studentCourses;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<OrderCourse> orderCourseList;
}