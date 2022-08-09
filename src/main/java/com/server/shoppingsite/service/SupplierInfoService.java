package com.server.shoppingsite.service;

import com.server.shoppingsite.dto.requestDto.SupplierInfoRequesetDto;
import com.server.shoppingsite.model.Address;
import com.server.shoppingsite.model.SupplierInfo;
import com.server.shoppingsite.repository.SupplierInfoRepository;
import com.server.shoppingsite.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupplierInfoService {
    @Autowired
    private SupplierInfoRepository supplierInfoRepository;

    @Autowired
    SupplierRepository supplierRepository;

//    @Autowired
//    private SupplierService supplierService;

    //=========================================================================================Implementation
//    public SupplierInfo addSupplierInfo(SupplierInfoRequesetDto supplierInfoRequesetDto) {
//        if (supplierInfoRequesetDto.getSupplierId() == null) {
//            throw new IllegalArgumentException("Supplier info needs a supplier id");
//        }
//
//        Supplier supplier = supplierService.getSupplierById(supplierInfoRequesetDto.getSupplierId());
//
//        Address address = new Address();
//        address.setAddressStreet(supplierInfoRequesetDto.getAddress().getAddressStreet());
//        address.setAddressBuilding(supplierInfoRequesetDto.getAddress().getAddressBuilding());
//        address.setAddressEstate(supplierInfoRequesetDto.getAddress().getAddressEstate());
//        address.setAddressFloor(supplierInfoRequesetDto.getAddress().getAddressFloor());
//        address.setAddressUnit(supplierInfoRequesetDto.getAddress().getAddressUnit());
//
//        SupplierInfo supplierInfo = new SupplierInfo();
//        supplierInfo.setAddress(address);
//        supplierInfo.setSupplier(supplier);
//        supplierInfo.setContactPerson(supplierInfoRequesetDto.getContactPerson());
//        supplierInfo.setEmail(supplierInfoRequesetDto.getEmail());
//        supplierInfo.setTelephone(supplierInfoRequesetDto.getTelephone());
//
//        return supplierInfoRepository.save(supplierInfo);
//    }

//    public List<SupplierInfo> getSupplierInfos() {
//        return StreamSupport
//                .stream(supplierInfoRepository.findAll().spliterator(), false)
//                .collect(Collectors.toList());
//    }

    public SupplierInfo getSupplierInfo(Long supplierInfoId) {
        SupplierInfo supplierInfo = supplierInfoRepository.findById(supplierInfoId).orElseThrow(
                () -> new IllegalArgumentException("Supplier info with id: " + supplierInfoId + " could not be found."));
        return supplierInfo;
    }

    public SupplierInfo getSupplierInfoById(Long supplierInfoId) {
        return getSupplierInfo(supplierInfoId);
    }

//    public SupplierInfo deleteSupplierInfo(Long supplierInfoId) {
//        SupplierInfo supplierInfo = getSupplierInfo(supplierInfoId);
//        supplierInfoRepository.delete(supplierInfo);
//        return supplierInfo;
//    }

    @Transactional
    public SupplierInfo editSupplierInfo(Long supplierInfoId, SupplierInfoRequesetDto supplierInfoRequesetDto) {
        SupplierInfo supplierInfo = getSupplierInfo(supplierInfoId);

        // set address
        Address address =  supplierInfo.getAddress();
        address.setAddressStreet(supplierInfoRequesetDto.getAddress().getAddressStreet());
        address.setAddressBuilding(supplierInfoRequesetDto.getAddress().getAddressBuilding());
        address.setAddressEstate(supplierInfoRequesetDto.getAddress().getAddressEstate());
        address.setAddressFloor(supplierInfoRequesetDto.getAddress().getAddressFloor());
        address.setAddressUnit(supplierInfoRequesetDto.getAddress().getAddressUnit());

        supplierInfo.setAddress(address);
        supplierInfo.setContactPerson(supplierInfoRequesetDto.getContactPerson());
        supplierInfo.setEmail(supplierInfoRequesetDto.getEmail());
        supplierInfo.setTelephone(supplierInfoRequesetDto.getTelephone());

        return supplierInfo;
    }
}
