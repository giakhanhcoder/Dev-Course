package com.develop.devcourse.domain.payment.dto.request;


import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {

    private String orderId;

    private String fullName;

    private String email;

    private String phoneNumber;

    private String note;

    private LocalDateTime orderDate;

    private String trackingNumber;

    private String status;

    private Long totalMoney;

    private String shippingMethod;

    private String shippingAddress;

    private LocalDate shippingDate;

    private String paymentMethod;

    private List<CartItemRequest> cartItems;
}
