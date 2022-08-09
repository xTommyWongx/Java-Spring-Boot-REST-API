package com.server.shoppingsite.service;

import com.server.shoppingsite.dto.requestDto.ProductRequestDto;
import com.server.shoppingsite.dto.responseDto.ProductClientResponseDto;
import com.server.shoppingsite.exception.CustomException;
import com.server.shoppingsite.exception.CustomExceptionStatus;
import com.server.shoppingsite.model.Category;
import com.server.shoppingsite.model.Product;
import com.server.shoppingsite.model.Supplier;
import com.server.shoppingsite.repository.CategoryRepository;
import com.server.shoppingsite.repository.ProductRepository;
import com.server.shoppingsite.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public Long createProduct(ProductRequestDto productRequestDto) {
        List<Product> skuProduct = productRepository.findAllBySku(productRequestDto.getSku());
        if (!skuProduct.isEmpty()) throw new CustomException(CustomExceptionStatus.PRODUCT_NOT_FOUND);
        Category category = categoryRepository.findById(productRequestDto.getCategoryId())
                .orElseThrow(() -> new CustomException(CustomExceptionStatus.CATEGORY_NOT_FOUND));
        Supplier supplier = supplierRepository.findById(productRequestDto.getSupplierId())
                .orElseThrow(() -> new CustomException(CustomExceptionStatus.SUPPLIER_NOT_FOUND));

        Product product = new Product(productRequestDto);
        product.setSupplier(supplier);
        product.setCategory(category);
        productRepository.save(product);
        return product.getId();
    }

    public ProductClientResponseDto getProductById(Long id) {
        return productRepository.findByProductClientById(id)
                .orElseThrow(() -> new CustomException(CustomExceptionStatus.PRODUCT_NOT_FOUND));
    }

}
