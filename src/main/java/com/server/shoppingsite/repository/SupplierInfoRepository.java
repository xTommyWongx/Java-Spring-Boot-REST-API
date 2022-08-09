package com.server.shoppingsite.repository;

import com.server.shoppingsite.model.SupplierInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierInfoRepository extends JpaRepository<SupplierInfo, Long> {
}
