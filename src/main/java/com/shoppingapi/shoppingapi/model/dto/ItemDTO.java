package com.shoppingapi.shoppingapi.model.dto;



import com.shoppingapi.shoppingapi.model.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    private String productIdentifier;
    private double price;

     public ItemDTO(Item item) {
        this.productIdentifier = item.getProductIdentifier();
        this.price = item.getPrice();
    }
}
