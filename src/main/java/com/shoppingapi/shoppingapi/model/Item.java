package com.shoppingapi.shoppingapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
@Document(collection = "item")
public class Item {
    @Id
    private String productIdentifier;
    private Double price;
}
