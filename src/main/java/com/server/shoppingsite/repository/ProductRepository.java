package com.server.shoppingsite.repository;

import com.server.shoppingsite.dto.responseDto.ProductClientResponseDto;
import com.server.shoppingsite.model.Product;
import com.server.shoppingsite.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllBySku(String sku);
    Optional<Product> findByIdAndSupplier(Long productId, Supplier supplier);

    @Query("SELECT DISTINCT p FROM Product p " +
            "LEFT JOIN FETCH p.supplier " +
            "LEFT JOIN FETCH p.category " +
            "LEFT JOIN FETCH p.productFunction " +
            "LEFT JOIN FETCH p.inventories " +
            "LEFT JOIN p.orderProductRelations opr " +
//            "LEFT JOIN opr.orders " +
//            "LEFT JOIN FETCH p.supplierOrdersProductRelations sop " +
//            "LEFT JOIN FETCH sop.supplierOrders so " +
            "WHERE p.id = :productId ")
    Optional<ProductClientResponseDto> findByProductClientById(@Param(value = "productId") Long productId);
}
