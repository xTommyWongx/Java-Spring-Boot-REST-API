package com.server.shoppingsite.dto.requestDto;

import lombok.Data;

@Data
public class OrderOrderProductRequestDto {
    private double cost;
    private Integer quantity;
    private Long productId;
}
