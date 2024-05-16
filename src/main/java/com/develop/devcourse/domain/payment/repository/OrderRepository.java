package com.develop.devcourse.domain.payment.repository;

import com.develop.devcourse.domain.payment.model.Order;
import com.develop.devcourse.domain.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {

    Order findByOrderIdAndUser(String orderId, User user);
}
