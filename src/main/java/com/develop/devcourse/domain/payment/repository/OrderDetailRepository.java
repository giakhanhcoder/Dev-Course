package com.develop.devcourse.domain.payment.repository;

import com.develop.devcourse.domain.payment.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
