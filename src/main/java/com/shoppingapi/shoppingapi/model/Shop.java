package com.shoppingapi.shoppingapi.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
@Document(collection = "shop")
public class Shop {
    @Id
    private String id;
    private String userIdentifier;
    private Date date;
    
    @DBRef
    private List<Item> items;
    
    private Double total;
}