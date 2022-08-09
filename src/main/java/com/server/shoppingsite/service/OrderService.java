package com.server.shoppingsite.service;

import com.server.shoppingsite.dto.requestDto.OrderOrderProductRequestDto;
import com.server.shoppingsite.dto.requestDto.OrderRequestDto;
import com.server.shoppingsite.exception.CustomException;
import com.server.shoppingsite.exception.CustomExceptionStatus;
import com.server.shoppingsite.model.Orders;
import com.server.shoppingsite.model.Product;
import com.server.shoppingsite.repository.OrderRepository;
import com.server.shoppingsite.repository.ProductRepository;
import com.server.shoppingsite.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Long createOrder(OrderRequestDto orderRequestDto) {
        //todo create user or get current user

        Orders order = Orders.createOrder(orderRequestDto);

        for (OrderOrderProductRequestDto dto : orderRequestDto.getOrderOrderProductRequestDtos()) {
            Product product = productRepository.findById(dto.getProductId())
                    .orElseThrow(() -> new CustomException(CustomExceptionStatus.PRODUCT_NOT_FOUND));
            if (product.getCost() != dto.getCost())
                throw new CustomException(CustomExceptionStatus.PRODUCT_COST_NOT_CORRECT);
            order.addProduct(dto, product);
        }
        orderRepository.save(order);
        return order.getId();
    }
}
