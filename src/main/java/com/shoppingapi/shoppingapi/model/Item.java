package com.shoppingapi.shoppingapi.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "items")
public class Item {

    @Id
    private String id;
    private String productIdentifier;
    private double price;
}
