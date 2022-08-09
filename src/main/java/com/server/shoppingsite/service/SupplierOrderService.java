package com.server.shoppingsite.service;

import com.server.shoppingsite.dto.requestDto.SupplierOrderProductRequestDto;
import com.server.shoppingsite.dto.requestDto.SupplierOrderRequestDto;
import com.server.shoppingsite.exception.CustomException;
import com.server.shoppingsite.exception.CustomExceptionStatus;
import com.server.shoppingsite.model.Product;
import com.server.shoppingsite.model.Supplier;
import com.server.shoppingsite.model.SupplierOrders;
import com.server.shoppingsite.repository.ProductRepository;
import com.server.shoppingsite.repository.SupplierOrdersRepository;
import com.server.shoppingsite.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SupplierOrderService {
    private final SupplierRepository supplierRepository;
    private final ProductRepository productRepository;
    private final SupplierOrdersRepository supplierOrdersRepository;

    @Transactional
    public Long createOrder(SupplierOrderRequestDto supplierOrderRequestDto) {
        Supplier supplier = supplierRepository.findById(supplierOrderRequestDto.getSupplierId())
                .orElseThrow(() -> new CustomException(CustomExceptionStatus.SUPPLIER_NOT_FOUND));

        //todo check all product exist
        SupplierOrders supplierOrders = SupplierOrders.createOrder(supplier, supplierOrderRequestDto);

        for (SupplierOrderProductRequestDto dto : supplierOrderRequestDto.getSupplierOrderProductRequestDtos()) {
            Product product = productRepository.findByIdAndSupplier(dto.getProductId(), supplier)
                    .orElseThrow(() -> new CustomException(CustomExceptionStatus.PRODUCT_NOT_FOUND));
            supplierOrders.addProduct(dto, product);
        }
        supplierOrdersRepository.save(supplierOrders);
        return supplierOrders.getId();
    }
}
