package com.develop.devcourse.domain.payment.dto.response;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {

    private String orderId;

    private String fullName;

    private String email;

    private String phoneNumber;

    private String note;

    private LocalDateTime orderDate;

    private String trackingNumber;

    @JsonIgnore
    private String status;

    private Long totalMoney;

    private String shippingMethod;

    private String shippingAddress;

    private LocalDate shippingDate;

    private String paymentMethod;

    private List<OrderDetailResponse> orderDetails;

}
