package com.server.shoppingsite.dto.requestDto;

import com.server.shoppingsite.model.Address;
import lombok.Data;

@Data
public class SupplierInfoRequesetDto {
    private String contactPerson;
    private String email;
    private String telephone;
    private Address address;
    private Long supplierId;
}
