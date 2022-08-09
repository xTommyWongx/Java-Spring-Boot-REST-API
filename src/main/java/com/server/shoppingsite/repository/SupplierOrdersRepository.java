package com.server.shoppingsite.repository;

import com.server.shoppingsite.model.SupplierOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierOrdersRepository extends JpaRepository<SupplierOrders, Long> {
}
