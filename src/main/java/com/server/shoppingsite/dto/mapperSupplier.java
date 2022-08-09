package com.server.shoppingsite.dto;

import com.server.shoppingsite.dto.responseDto.SupplierResponseDto;
import com.server.shoppingsite.model.Supplier;

public class mapperSupplier {
    public static SupplierResponseDto supplierToSupplierResponseDto(Supplier supplier) {
        SupplierResponseDto supplierRequestDto = new SupplierResponseDto();

        supplierRequestDto.setId(supplier.getId());
        supplierRequestDto.setName(supplier.getName());
        supplierRequestDto.setSupplierInfos(supplier.getSupplierInfos());

        return supplierRequestDto;
    }
}
