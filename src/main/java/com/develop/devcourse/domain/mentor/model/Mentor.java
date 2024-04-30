package com.develop.devcourse.domain.mentor.model;

import com.develop.devcourse.domain.course.model.Course;
import com.develop.devcourse.domain.security.model.User;
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
@Table(name = "mentor")
public class Mentor {

    @Id
    @Column(name = "user_id")
    private String mentorId;

    @Column(name = "degree")
    private String degree;

    @Column(name = "experience")
    private int experience;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @MapsId
    private User user;


    @OneToMany(mappedBy = "mentor")
    private List<Course> course;
}
