package com.server.shoppingsite.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.shoppingsite.dto.requestDto.InventoryRequestDto;
import com.server.shoppingsite.dto.requestDto.ProductRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String sku;

    private double cost;

    private double sellPrice;

    private Integer unitInStock;

    private float discountRate;

    private Boolean isPreOrder;

    private Boolean isActive;

    // uni-direction
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    @JsonIgnoreProperties("supplierInfos")
    private Supplier supplier;

    // uni-direction
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    // bi-direction
    @OneToOne(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("product")
    private ProductFunction productFunction;

    //bi-direction
    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("product")
    private List<Inventory> inventories = new ArrayList<>();

    // bi-direction
    @OneToMany(mappedBy = "product")
    @JsonIgnoreProperties("product")
    private List<OrderProductRelation> orderProductRelations = new ArrayList<>();

    // bi-direction
//    @OneToMany(mappedBy = "product")
//    @JsonIgnoreProperties("product")
//    private List<SupplierOrdersProductRelation> supplierOrdersProductRelations = new ArrayList<>();

    public Product(ProductRequestDto productRequestDto) {
        this.name = productRequestDto.getName();
        this.sku = productRequestDto.getSku();
        this.cost = productRequestDto.getCost();
        this.sellPrice = productRequestDto.getSellPrice();
        this.unitInStock = productRequestDto.getUnitInStock();
        this.discountRate = productRequestDto.getDiscountRate();
        this.isPreOrder = productRequestDto.getIsPreOrder();
        this.isActive = true;
        this.addProductFunction(productRequestDto.getProductFunction());
    }

    public void addProductFunction(ProductFunction productFunction) {
        productFunction.setProduct(this);
        this.productFunction = productFunction;
    }

    public void addInventory(InventoryRequestDto inventoryRequestDto) {
        Inventory inventory = Inventory.builder()
                .quantity(inventoryRequestDto.getQuantity())
                .isDeleted(false)
                .remark(inventoryRequestDto.getRemark())
                .product(this)
                .build();
        inventories.add(inventory);
    }
}
