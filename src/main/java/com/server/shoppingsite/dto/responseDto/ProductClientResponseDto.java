package com.server.shoppingsite.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.shoppingsite.model.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class ProductClientResponseDto {
    private Long id;
    private String name;
    private String sku;
    private double sellPrice;
    private Integer unitInStock;
    private float discountRate;
    private Boolean isPreOrder;
    private Boolean isActive;

    @JsonIgnoreProperties("supplierInfos")
    private Supplier supplier;

    private Category category;

    @JsonIgnoreProperties("product")
    private ProductFunction productFunction;

    @JsonIgnoreProperties("product")
    private List<Inventory> inventories = new ArrayList<>();

    @JsonIgnoreProperties("product")
    private List<OrderProductRelation> orders = new ArrayList<>();

//    @JsonIgnoreProperties("product")
//    private List<SupplierOrdersProductRelation> supplierOrdersProductRelations = new ArrayList<>();

    public ProductClientResponseDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.sku = product.getSku();
        this.sellPrice = product.getSellPrice();
        this.unitInStock = product.getInventories().stream().mapToInt(Inventory::getQuantity).sum();
        this.discountRate = product.getDiscountRate();
        this.isPreOrder = product.getIsPreOrder();
        this.isActive = product.getIsActive();
        this.supplier = product.getSupplier();
        this.category = product.getCategory();
        this.productFunction = product.getProductFunction();
        this.inventories = product.getInventories();
//        this.supplierOrdersProductRelations = product.getSupplierOrdersProductRelations();
        this.orders = product.getOrderProductRelations();
    }
}
