package com.server.shoppingsite.dto.responseDto;

import com.server.shoppingsite.model.SupplierInfo;
import lombok.Data;

import java.util.List;

@Data
public class SupplierResponseDto {
    private Long id;
    private String name;
    private List<SupplierInfo> supplierInfos;
}
