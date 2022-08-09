package com.server.shoppingsite.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "cre_by")
    private String createdBy;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<SupplierInfo> supplierInfos = new ArrayList<>();

    public Supplier(String name, String createdBy) {
        this.name = name;
        this.createdBy = createdBy;
    }

    public void addSupplierInfo(SupplierInfo supplierInfo) {
        supplierInfos.add(supplierInfo);
        supplierInfo.setSupplier(this);
    }

    public void removeSupplierInfo(SupplierInfo supplierInfo) {
        supplierInfos.remove(supplierInfo);
        supplierInfo.setSupplier(null);
    }
}
