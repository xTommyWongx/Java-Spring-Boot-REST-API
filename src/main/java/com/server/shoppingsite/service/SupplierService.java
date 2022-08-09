package com.server.shoppingsite.service;

import com.server.shoppingsite.dto.mapperSupplier;
import com.server.shoppingsite.dto.requestDto.SupplierRequestDto;
import com.server.shoppingsite.dto.responseDto.SupplierResponseDto;
import com.server.shoppingsite.model.Address;
import com.server.shoppingsite.model.Supplier;
import com.server.shoppingsite.model.SupplierInfo;
import com.server.shoppingsite.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierInfoService supplierInfoService;

    //=========================================================================================Implementation
    public Supplier addSupplier(SupplierRequestDto supplierRequestDto) {
        Supplier supplier = new Supplier();
        supplier.setName(supplierRequestDto.getName());
        supplier.setCreatedBy("Tommy");
        return supplierRepository.save(supplier);
    }

    public List<Supplier> getSuppliers() {
        return StreamSupport
                .stream(supplierRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Supplier getSupplier(Long supplierId) {
        return supplierRepository.findById(supplierId).orElseThrow(
                () -> new IllegalArgumentException("Supplier with id: " + supplierId + " could not be found."));
    }

    public SupplierResponseDto getSupplierById(Long supplierId) {
        Supplier supplier = getSupplier(supplierId);
        return mapperSupplier.supplierToSupplierResponseDto(supplier);
    }

    public Supplier deleteSupplier(Long supplierId) {
        Supplier supplier = getSupplier(supplierId);
        supplierRepository.delete(supplier);
        return supplier;
    }

    @Transactional
    public Supplier editSupplier(Long supplierId, SupplierRequestDto supplierRequestDto) {
        Supplier supplier = getSupplier(supplierId);
        supplier.setName(supplierRequestDto.getName());
        return supplier;
    }

    @Transactional
    public SupplierResponseDto addSupplierInfoToSupplier(Long supplierId, SupplierRequestDto supplierRequestDto) {
        if (supplierRequestDto.getSupplierInfo() == null) {
            throw new IllegalArgumentException("Supplier info needs to be provided");
        }

        Supplier supplier = getSupplier(supplierId);

        final Address addressFromRequest = supplierRequestDto.getSupplierInfo().getAddress();
        Address address = new Address();
        address.setAddressStreet(addressFromRequest.getAddressStreet());
        address.setAddressBuilding(addressFromRequest.getAddressBuilding());
        address.setAddressEstate(addressFromRequest.getAddressEstate());
        address.setAddressFloor(addressFromRequest.getAddressFloor());
        address.setAddressUnit(addressFromRequest.getAddressUnit());

        SupplierInfo supplierInfoFromRequest = supplierRequestDto.getSupplierInfo();
        SupplierInfo supplierInfo = new SupplierInfo();
        supplierInfo.setAddress(address);
        supplierInfo.setContactPerson(supplierInfoFromRequest.getContactPerson());
        supplierInfo.setEmail(supplierInfoFromRequest.getEmail());
        supplierInfo.setTelephone(supplierInfoFromRequest.getTelephone());

        supplier.addSupplierInfo(supplierInfo);
        return mapperSupplier.supplierToSupplierResponseDto(supplier);
    }

    @Transactional
    public SupplierResponseDto deleteSupplierInfoFromSupplier(Long supplierId, Long supplierInfoId) {
        Supplier supplier = getSupplier(supplierId);
        SupplierInfo supplierInfo = supplierInfoService.getSupplierInfoById(supplierInfoId);
        if (supplier.getSupplierInfos().contains(supplierInfo)) {
            supplier.removeSupplierInfo(supplierInfo);
        }
        return mapperSupplier.supplierToSupplierResponseDto(supplier);
    }
}
