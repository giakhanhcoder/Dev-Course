package com.develop.devcourse.domain.payment.dto.request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartItemRequest {

    private String courseId;

}
