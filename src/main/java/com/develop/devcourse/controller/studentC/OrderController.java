package com.develop.devcourse.controller.studentC;

import com.develop.devcourse.domain.payment.dto.request.OrderRequest;
import com.develop.devcourse.domain.payment.dto.response.OrderResponse;
import com.develop.devcourse.domain.payment.service.OrderService;
import com.develop.devcourse.domain.payment.service.VNPayService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final VNPayService vnPayService;

    @PostMapping("")
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrderRequest orderRequest,
                                         HttpServletRequest request) throws Exception {
//        orderService.createOrder(orderRequest);
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        return ResponseEntity.ok( vnPayService.createOrder(baseUrl, orderRequest));
    }

   @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id) {
        OrderResponse orderResponse = orderService.getOrderById(id);
        return ResponseEntity.ok(orderResponse);
    }

    @GetMapping("")
    public ResponseEntity<OrderResponse> getAllOrders() {
        OrderResponse orderResponse = orderService.getAllOrders();
        return ResponseEntity.ok(orderResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable Long id, @Valid @RequestBody OrderRequest orderDTO) {
        orderService.updateOrderById(id, orderDTO);
        return ResponseEntity.ok("order updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrderById(id);
        return ResponseEntity.ok("order deleted successfully");
    }
}
