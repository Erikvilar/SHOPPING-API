package com.shoppingapi.shoppingapi.repository;

import java.util.List;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.shoppingapi.shoppingapi.model.Item;


public interface ItemRepository extends MongoRepository<Item, String> {



    
}