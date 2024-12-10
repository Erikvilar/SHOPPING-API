package com.shoppingapi.shoppingapi.model;



import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "shops")
public class Shop {

    @Id
    private ObjectId id;
    private String userIdentifier;
    private String date;
    private List<Item> items; 
    private double total;
}
