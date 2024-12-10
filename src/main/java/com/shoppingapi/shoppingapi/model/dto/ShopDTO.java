package com.shoppingapi.shoppingapi.model.dto;

import java.util.List;

import org.bson.types.ObjectId;

import com.shoppingapi.shoppingapi.model.Item;
import com.shoppingapi.shoppingapi.model.Shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopDTO {

    private String id;
    private String userIdentifier;
    private String date;
    private List<ItemDTO> items;
    private double total;

    public ShopDTO(Shop shop) {
        this.id = shop.getId().toString();
        this.userIdentifier = shop.getUserIdentifier();
        this.date = shop.getDate();
     
        this.items = shop.getItems().stream()
                         .map(item -> new ItemDTO(item))  
                         .toList();
        this.total = shop.getTotal();
    }
}
