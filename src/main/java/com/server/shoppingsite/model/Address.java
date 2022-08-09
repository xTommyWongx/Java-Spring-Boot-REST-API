package com.server.shoppingsite.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Column(name = "add_street")
    private String addressStreet;

    @Column(name = "add_estate")
    private String addressEstate;

    @Column(name = "add_phase")
    private String addressPhase;

    @Column(name = "add_building")
    private String addressBuilding;

    @Column(name = "add_floor")
    private String addressFloor;

    @Column(name = "add_unit")
    private String addressUnit;

    @Column(name = "add_remark")
    private String addressMark;
}
