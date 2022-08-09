package com.server.shoppingsite.dto.requestDto;

import com.server.shoppingsite.model.SupplierInfo;
import lombok.Data;

@Data
public class SupplierRequestDto {
    private String name;
    private SupplierInfo supplierInfo;
}
