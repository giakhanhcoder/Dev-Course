package com.develop.devcourse.domain.student.model;

import com.develop.devcourse.domain.security.model.User;
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
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "user_id")
    private String studentId;

    @Column(name = "performance")
    private String performance;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @MapsId
    private User user;

//    @OneToMany(mappedBy = "student")
//    private List<StudentCourse> studentCourses;

//    @OneToMany(mappedBy = "student")
//    private List<StudentAnswer> studentAnswers;

}
