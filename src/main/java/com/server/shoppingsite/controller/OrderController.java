package com.server.shoppingsite.controller;

import com.server.shoppingsite.dto.CustomResponse;
import com.server.shoppingsite.dto.DataResponse;
import com.server.shoppingsite.dto.requestDto.OrderRequestDto;
import com.server.shoppingsite.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/add")
    public DataResponse<Long> addOrder(@RequestBody final OrderRequestDto orderRequestDto) {
        Long id = orderService.createOrder(orderRequestDto);
        return CustomResponse.getDataResponse(id);
    }

}
