package com.server.shoppingsite.dto.requestDto;

import com.server.shoppingsite.model.ProductFunction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {

    private String name;

    @NotNull
    private String sku;

    private double cost;

    private double sellPrice;

    private Integer unitInStock;

    private float discountRate;

    private Boolean isPreOrder;

    private Boolean isActive;

    private Long supplierId;

    @NotNull
    private Long categoryId;

    private ProductFunction productFunction;
}
