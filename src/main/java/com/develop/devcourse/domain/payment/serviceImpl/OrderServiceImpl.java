package com.develop.devcourse.domain.payment.serviceImpl;

import com.develop.devcourse.domain.course.model.Course;
import com.develop.devcourse.domain.course.repository.CourseRepository;
import com.develop.devcourse.domain.payment.dto.request.CartItemRequest;
import com.develop.devcourse.domain.payment.dto.request.OrderRequest;
import com.develop.devcourse.domain.payment.dto.response.OrderResponse;
import com.develop.devcourse.domain.payment.model.Order;
import com.develop.devcourse.domain.payment.model.OrderDetail;
import com.develop.devcourse.domain.payment.repository.OrderDetailRepository;
import com.develop.devcourse.domain.payment.repository.OrderRepository;
import com.develop.devcourse.domain.payment.service.OrderService;
import com.develop.devcourse.domain.security.model.User;
import com.develop.devcourse.domain.security.repository.UserRepository;
import com.develop.devcourse.domain.security.serviceImpl.UserDetailsImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final OrderDetailRepository orderDetailRepository;

    // nếu nhớ thì bỏ @Transactional đi xem có chạy được không
    @Transactional
    @Override
    public Order createOrder(OrderRequest orderRequest) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByEmail(userDetails.getEmail()).orElseThrow();
        Order order = modelMapper.map(orderRequest, Order.class);
        order.setUser(user);
        // check shipping date greater than today
        LocalDate shippingDate = orderRequest.getShippingDate() == null ? LocalDate.now() : orderRequest.getShippingDate();
        if (shippingDate.isBefore(LocalDate.now())) {
            throw new RuntimeException("Date must be at least today !");
        }
        order.setShippingDate(shippingDate);
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (CartItemRequest cartItemRequest : orderRequest.getCartItems()){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            Course course = courseRepository.findById(cartItemRequest.getCourseId()).orElseThrow();
            orderDetail.setCourse(course);
            orderDetail.setCoursePrice(course.getCoursePrice());
            orderDetails.add(orderDetail);
        }
        orderDetailRepository.saveAll(orderDetails);
        orderRepository.save(order);
        return order;
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        return null;
    }

    @Override
    public OrderResponse getAllOrders() {
        return null;
    }

    @Override
    public void deleteOrderById(Long id) {

    }

    @Override
    public void updateOrderById(Long id, OrderRequest orderDTO) {

    }
}
