package com.server.shoppingsite.controller;

import com.server.shoppingsite.dto.requestDto.SupplierRequestDto;
import com.server.shoppingsite.dto.responseDto.SupplierResponseDto;
import com.server.shoppingsite.model.Supplier;
import com.server.shoppingsite.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @PostMapping("/add")
    public ResponseEntity<Supplier> addSupplier(@RequestBody final SupplierRequestDto supplierRequestDto) {
        Supplier supplier = supplierService.addSupplier(supplierRequestDto);
        return ResponseEntity.ok(supplier);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        List<Supplier> suppliers = supplierService.getSuppliers();
        return ResponseEntity.ok(suppliers);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<SupplierResponseDto> getSupplierById(@PathVariable final Long id) {
        SupplierResponseDto supplier = supplierService.getSupplierById(id);
        return ResponseEntity.ok(supplier);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Supplier> deleteSupplier(@PathVariable final Long id) {
        Supplier supplier = supplierService.deleteSupplier(id);
        return ResponseEntity.ok(supplier);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Supplier> editSupplier(@PathVariable final Long id,
                                                 @RequestBody final SupplierRequestDto supplierRequestDto) {
        Supplier supplier = supplierService.editSupplier(id, supplierRequestDto);
        return ResponseEntity.ok(supplier);
    }

    @PostMapping("/addSupplierInfo/{supplierId}")
    public ResponseEntity<SupplierResponseDto> addSupplierInfoToSupplier(@PathVariable final Long supplierId,
                                                                         @RequestBody final SupplierRequestDto supplierRequestDto) {
        SupplierResponseDto supplierResponseDto = supplierService.addSupplierInfoToSupplier(supplierId, supplierRequestDto);
        return ResponseEntity.ok(supplierResponseDto);
    }

    @DeleteMapping("/removeSupplierInfo/{supplierInfoId}/fromSupplier/{supplierId}")
    public ResponseEntity<SupplierResponseDto> removeSupplierInfoFromSupplier(@PathVariable final Long supplierInfoId,
                                                                              @PathVariable final Long supplierId) {
        SupplierResponseDto supplierResponseDto = supplierService.deleteSupplierInfoFromSupplier(supplierId, supplierInfoId);
        return ResponseEntity.ok(supplierResponseDto);
    }
}
