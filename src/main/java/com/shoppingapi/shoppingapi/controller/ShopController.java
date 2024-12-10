package com.shoppingapi.shoppingapi.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shoppingapi.shoppingapi.model.dto.ShopDTO;
import com.shoppingapi.shoppingapi.service.ShopService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("shopping")
@RequiredArgsConstructor
public class ShopController {

    
    private final ShopService shopService;


 

    @PostMapping
    public ResponseEntity<ShopDTO> create(@RequestBody ShopDTO shopDTO) {
        return shopService.create(shopDTO);
    }
    @GetMapping
    public ResponseEntity<List<ShopDTO>> getAllShops() {
        return shopService.getAllShops();  
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ShopDTO> getShopById(@PathVariable String id) {
        return shopService.getShopById(id); 
    }

}
