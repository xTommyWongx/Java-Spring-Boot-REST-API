package com.server.shoppingsite.dto.requestDto;

import com.server.shoppingsite.model.enumType.EOrderStatus;
import com.server.shoppingsite.model.enumType.EPaymentStatus;
import com.server.shoppingsite.model.enumType.EShippingCostMethod;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderRequestDto {
    private EOrderStatus status;
    private EPaymentStatus paymentStatus;
    private String paymentMethod;
    private String shipper;
    private String shippingAddress;
    private EShippingCostMethod shippingCostMethod;
    private String email;
    private String remark;
    private Long userId;
    private List<OrderOrderProductRequestDto> orderOrderProductRequestDtos = new ArrayList<>();
}
