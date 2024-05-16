package com.develop.devcourse.domain.payment.service;

import com.develop.devcourse.domain.payment.dto.request.OrderRequest;
import com.develop.devcourse.domain.payment.dto.response.OrderResponse;
import com.develop.devcourse.domain.payment.model.Order;

public interface OrderService {
    Order createOrder(OrderRequest orderRequest);

    OrderResponse getOrderById(Long id);

    OrderResponse getAllOrders();

    void deleteOrderById(Long id);

    void updateOrderById(Long id, OrderRequest orderDTO);

}
