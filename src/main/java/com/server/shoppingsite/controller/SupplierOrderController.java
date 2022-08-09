package com.server.shoppingsite.controller;

import com.server.shoppingsite.dto.CustomResponse;
import com.server.shoppingsite.dto.DataResponse;
import com.server.shoppingsite.dto.requestDto.SupplierOrderRequestDto;
import com.server.shoppingsite.service.SupplierOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier-order")
@RequiredArgsConstructor
public class SupplierOrderController {
    private final SupplierOrderService supplierOrderService;

    @PostMapping("/add")
    public DataResponse<Long> addOrder(@RequestBody final SupplierOrderRequestDto supplierOrderRequestDto) {
        Long orderId = supplierOrderService.createOrder(supplierOrderRequestDto);
        return CustomResponse.getDataResponse(orderId);
    }
}
