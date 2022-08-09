package com.server.shoppingsite.dto.requestDto;

import lombok.Data;

@Data
public class SupplierOrderProductRequestDto {
    private double cost;
    private Integer quantity;
    private Long productId;
}
