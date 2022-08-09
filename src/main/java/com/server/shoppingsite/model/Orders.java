package com.server.shoppingsite.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.shoppingsite.dto.requestDto.OrderOrderProductRequestDto;
import com.server.shoppingsite.dto.requestDto.OrderRequestDto;
import com.server.shoppingsite.model.enumType.EOrderStatus;
import com.server.shoppingsite.model.enumType.EPaymentStatus;
import com.server.shoppingsite.model.enumType.EShippingCostMethod;
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
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private EOrderStatus status;
    private EPaymentStatus paymentStatus;
    private String paymentMethod;
    private String shipper;
    private String shippingAddress;
    private EShippingCostMethod shippingCostMethod;
    private String email;
    private String remark;

    //uni-direction
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // bi-direction
    @OneToMany(mappedBy = "orders", cascade = CascadeType.PERSIST)
    private List<OrderProductRelation> orderProductRelations  = new ArrayList<>();

    //todo: create onetomany: payment image

    public static Orders createOrder(OrderRequestDto orderRequestDto) {
        return Orders.builder()
                .status(orderRequestDto.getStatus())
                .paymentMethod(orderRequestDto.getPaymentMethod())
                .shipper(orderRequestDto.getShipper())
                .shippingAddress(orderRequestDto.getShippingAddress())
                .shippingCostMethod(orderRequestDto.getShippingCostMethod())
                .email(orderRequestDto.getEmail())
                .remark(orderRequestDto.getRemark())
                .orderProductRelations(new ArrayList<>())
                .build();
    }

    public void addProduct(OrderOrderProductRequestDto dto, Product product) {
        OrderProductRelation orderProductRelation = OrderProductRelation.builder()
                .cost(product.getCost())
                .quantity(dto.getQuantity())
                .isShipped(false)
                .isDeleted(false)
                .orders(this)
                .product(product)
                .build();

        this.orderProductRelations.add(orderProductRelation);
        product.getOrderProductRelations().add(orderProductRelation);
    }
}
