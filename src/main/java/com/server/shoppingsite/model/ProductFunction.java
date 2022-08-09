package com.server.shoppingsite.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ProductFunction")
public class ProductFunction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isBelt = false;
    private Boolean isElastic = false;
    private Boolean isRubber = false;
    private Boolean isJapan = false;
    private Boolean isKorea = false;
    private Boolean isZipper = false;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
