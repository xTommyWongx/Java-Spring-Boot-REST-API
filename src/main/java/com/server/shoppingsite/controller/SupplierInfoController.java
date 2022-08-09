package com.server.shoppingsite.controller;

import com.server.shoppingsite.dto.requestDto.SupplierInfoRequesetDto;
import com.server.shoppingsite.model.SupplierInfo;
import com.server.shoppingsite.service.SupplierInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplierinfo")
public class SupplierInfoController {
    @Autowired
    SupplierInfoService supplierInfoService;

//    @PostMapping("/add")
//    public ResponseEntity<SupplierInfo> addSupplierInfo(@RequestBody @Valid final SupplierInfoRequesetDto supplierInfoRequesetDto) {
//        SupplierInfo supplierInfo = supplierInfoService.addSupplierInfo(supplierInfoRequesetDto);
//        return ResponseEntity.ok(supplierInfo);
//    }
//
//    @GetMapping("/getall")
//    public ResponseEntity<List<SupplierInfo>> getSupplierInfos() {
//        List<SupplierInfo> supplierInfo = supplierInfoService.getSupplierInfos();
//        return ResponseEntity.ok(supplierInfo);
//    }
//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<SupplierInfo> getSupplierInfoById(@PathVariable final Long id) {
//        SupplierInfo supplierInfo = supplierInfoService.getSupplierInfoById(id);
//        return ResponseEntity.ok(supplierInfo);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<SupplierInfo> deleteSupplierInfo(@PathVariable final Long id) {
//        SupplierInfo supplierInfo = supplierInfoService.deleteSupplierInfo(id);
//        return ResponseEntity.ok(supplierInfo);
//    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<SupplierInfo> editSupplierInfo(@PathVariable final Long id,
                                                         @RequestBody final SupplierInfoRequesetDto supplierInfoRequesetDto) {
        SupplierInfo supplierInfo = supplierInfoService.editSupplierInfo(id, supplierInfoRequesetDto);
        return ResponseEntity.ok(supplierInfo);
    }
}
