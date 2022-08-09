package com.server.shoppingsite.dto.requestDto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SupplierOrderRequestDto {
    private String orderDate;
    private String estimateArrivalDate;
    private Long supplierId;
    private List<SupplierOrderProductRequestDto> supplierOrderProductRequestDtos = new ArrayList<>();
}
