package com.shoppingapi.shoppingapi.model.dto;

import java.util.Date;
import java.util.List;

import com.shoppingapi.shoppingapi.model.Shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopDTO {
    private String userIdentifier;
    private Date date;
    private List<ItemDTO> items;
    private Double total;

    public ShopDTO convertToDTO(Shop shop) {
    List<ItemDTO> itemDTOs = shop.getItems()
                                 .stream()
                                 .map(item -> new ItemDTO(item.getProductIdentifier(), item.getPrice()))
                                 .toList();

}
