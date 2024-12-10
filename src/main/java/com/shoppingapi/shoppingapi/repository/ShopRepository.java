package com.shoppingapi.shoppingapi.repository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shoppingapi.shoppingapi.model.Shop;

import java.util.Date;
import java.util.List;

@Repository
public interface ShopRepository extends MongoRepository<Shop, ObjectId> {
    // Busca compras por usuário
    List<Shop> findByUserIdentifier(String userIdentifier);

    List<Shop> findByDateBetween(Date startDate, Date endDate);

    List<Shop> findByItems_ProductIdentifier(String productIdentifier);

}