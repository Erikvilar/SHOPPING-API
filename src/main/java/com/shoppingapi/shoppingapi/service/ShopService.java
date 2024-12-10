package com.shoppingapi.shoppingapi.service;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shoppingapi.shoppingapi.model.Item;
import com.shoppingapi.shoppingapi.model.Shop;
import com.shoppingapi.shoppingapi.model.dto.ShopDTO;
import com.shoppingapi.shoppingapi.repository.ItemRepository;
import com.shoppingapi.shoppingapi.repository.ShopRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;
    private final ItemRepository itemRepository;

    public ResponseEntity<ShopDTO> create(ShopDTO shopDTO) {
        List<Item> items = shopDTO.getItems().stream().map(itemDTO -> {
            Item item = new Item();
            item.setProductIdentifier(itemDTO.getProductIdentifier());
            item.setPrice(itemDTO.getPrice());
            itemRepository.save(item);
            return item;
        }).toList();

        double total = items.stream().mapToDouble(Item::getPrice).sum();

        Shop shop = new Shop();
        shop.setUserIdentifier(shopDTO.getUserIdentifier());
        shop.setDate(shopDTO.getDate());
        shop.setItems(items);
        shop.setTotal(total);

        Shop savedShop = shopRepository.save(shop);

        ShopDTO responseDTO = new ShopDTO();
        responseDTO.setUserIdentifier(savedShop.getUserIdentifier());
        responseDTO.setDate(savedShop.getDate());
        responseDTO.setItems(shopDTO.getItems());
        responseDTO.setTotal(savedShop.getTotal());

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    public ResponseEntity<List<ShopDTO>> getAllShops() {

        List<Shop> shops = shopRepository.findAll();

        List<ShopDTO> shopDTOs = shops.stream()
                .map(ShopDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(shopDTOs);
    }

    public ResponseEntity<ShopDTO> getShopById(String id) {

        Shop shop = shopRepository.findById(new ObjectId(id)).orElse(null);

        if (shop == null) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        ShopDTO shopDTO = new ShopDTO(shop);

        return ResponseEntity.ok(shopDTO);
    }

}
