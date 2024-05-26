package com.example.POS.service;

import java.util.List;

import com.example.POS.entity.Item;

public interface ItemService {
    List<Item> getAllItems();
    Item getItemById(Long id);
    Item addItem(Item item);
    Item updateItem(Long id, Item item);
    void deleteItem(Long id); 

}
