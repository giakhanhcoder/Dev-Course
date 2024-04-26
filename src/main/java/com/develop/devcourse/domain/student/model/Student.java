package com.develop.devcourse.domain.student.model;

import com.develop.devcourse.domain.security.model.Users;
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
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "user_id")
    private String studentId;

    @Column(name = "performance")
    private String performance;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @MapsId
    private Users user;

//    @OneToMany(mappedBy = "student")
//    private List<StudentCourse> studentCourses;

//    @OneToMany(mappedBy = "student")
//    private List<StudentAnswer> studentAnswers;

}
