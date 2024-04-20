package com.develop.devcourse.domain.payment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class OrderCourseId implements Serializable {

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "course_id")
    private String courseId;

}
