package com.develop.devcourse.domain.payment.model;


import com.develop.devcourse.domain.course.model.Course;
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
@Table(name = "order_course")
public class OrderCourse {

    @EmbeddedId
    private OrderCourseId orderCourseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    @JsonIgnore
    private Orders orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("courseId")
    @JsonIgnore
    private Course course;
}
