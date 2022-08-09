package com.server.shoppingsite.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Supplier_Info")
@JsonIgnoreProperties({"supplier"})
public class SupplierInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contact_person")
    private String contactPerson;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @Size(max = 50)
    private String telephone;

    @Embedded
    private Address address;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    public SupplierInfo(String contactPerson, String email, String telephone, Address address, Supplier supplier) {
        this.contactPerson = contactPerson;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.supplier = supplier;
    }
}
