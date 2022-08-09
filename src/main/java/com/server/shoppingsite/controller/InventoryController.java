package com.server.shoppingsite.controller;


import com.server.shoppingsite.dto.CustomResponse;
import com.server.shoppingsite.dto.DataResponse;
import com.server.shoppingsite.dto.requestDto.InventoryRequestDto;
import com.server.shoppingsite.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @PostMapping("/add")
    public DataResponse<List<Long>> createInventory(@RequestBody InventoryRequestDto inventoryRequestDto) {
        List<Long> ids = inventoryService.createInventory(inventoryRequestDto);
        return CustomResponse.getDataResponse(ids);
    }
}
