package com.server.shoppingsite.service;

import com.server.shoppingsite.dto.requestDto.InventoryRequestDto;
import com.server.shoppingsite.exception.CustomException;
import com.server.shoppingsite.exception.CustomExceptionStatus;
import com.server.shoppingsite.model.Product;
import com.server.shoppingsite.repository.InventoryRepository;
import com.server.shoppingsite.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final ProductRepository productRepository;

    @Transactional
    public List<Long> createInventory(InventoryRequestDto inventoryRequestDto) {
        List<Long> ids = new ArrayList<>();
        for (InventoryRequestDto dto : inventoryRequestDto.getInventoryRequestDtos()) {
            Product product = productRepository.findById(dto.getProductId())
                    .orElseThrow(() -> new CustomException(CustomExceptionStatus.PRODUCT_NOT_FOUND));
            product.addInventory(dto);
            ids.add(product.getId());
        }
        return ids;
    }
}
