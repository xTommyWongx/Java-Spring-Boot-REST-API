package com.server.shoppingsite.dto.requestDto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class InventoryRequestDto {
    private Long productId;
    private Integer quantity;
    private String remark;
    List<InventoryRequestDto> inventoryRequestDtos = new ArrayList<>();
}
