package com.server.shoppingsite.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.shoppingsite.dto.requestDto.SupplierOrderProductRequestDto;
import com.server.shoppingsite.dto.requestDto.SupplierOrderRequestDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "SupplierOrders")
public class SupplierOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderDate;

    private String estimateArrivalDate;

    private Boolean isArrived;

    private String arrivalDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    @JsonIgnoreProperties("supplierInfos")
    private Supplier supplier;

    @OneToMany(mappedBy = "supplierOrders", cascade = CascadeType.PERSIST)
    private List<SupplierOrdersProductRelation> supplierOrdersProductRelations = new ArrayList<>();

    public static SupplierOrders createOrder(Supplier supplier, SupplierOrderRequestDto supplierOrderRequestDto) {
        return SupplierOrders.builder()
                .orderDate(supplierOrderRequestDto.getOrderDate())
                .estimateArrivalDate(supplierOrderRequestDto.getEstimateArrivalDate())
                .isArrived(false)
                .arrivalDate(supplierOrderRequestDto.getEstimateArrivalDate())
                .supplier(supplier)
                .supplierOrdersProductRelations(new ArrayList<>())
                .build();
    }

    public void addProduct(SupplierOrderProductRequestDto dto, Product product) {
        SupplierOrdersProductRelation supplierOrdersProductRelation = SupplierOrdersProductRelation.builder()
                .cost(dto.getCost())
                .quantity(dto.getQuantity())
                .isArrived(false)
                .supplierOrders(this)
                .product(product)
                .build();

        this.supplierOrdersProductRelations.add(supplierOrdersProductRelation);
//        product.getSupplierOrdersProductRelations().add(supplierOrdersProductRelation);
    }
}
