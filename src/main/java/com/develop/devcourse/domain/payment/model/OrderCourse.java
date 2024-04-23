package com.develop.devcourse.domain.payment.model;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("orderId")
//    @JoinColumn(name = "order_id")
//    @JsonIgnore
//    private Orders orders;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("courseId")
//    @JoinColumn(name = "course_id")
//    @JsonIgnore
//    private Course course;
}
