package com.server.shoppingsite.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "SupplierOrdersProduct")
public class SupplierOrdersProductRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double cost;

    private Integer quantity;

    private Boolean isArrived;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplierOrders_id")
    @JsonIgnoreProperties({"supplierOrdersProductRelations"})
    private SupplierOrders supplierOrders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
