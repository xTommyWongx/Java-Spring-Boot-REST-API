package com.server.shoppingsite.controller;

import com.server.shoppingsite.dto.CustomResponse;
import com.server.shoppingsite.dto.DataResponse;
import com.server.shoppingsite.dto.requestDto.ProductRequestDto;
import com.server.shoppingsite.dto.responseDto.ProductClientResponseDto;
import com.server.shoppingsite.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/add")
    public DataResponse<Long> addProduct(@RequestBody final ProductRequestDto productRequestDto) {
        Long productId = productService.createProduct(productRequestDto);
        return CustomResponse.getDataResponse(productId);
    }

    @GetMapping("/{id}")
    public DataResponse<ProductClientResponseDto> getProductionById(@PathVariable final Long id) {
        ProductClientResponseDto productClientResponseDto = productService.getProductById(id);
        return CustomResponse.getDataResponse(productClientResponseDto);
    }
}
