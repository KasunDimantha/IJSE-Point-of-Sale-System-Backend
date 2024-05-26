package com.example.POS.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.POS.entity.Item;
import com.example.POS.repository.ItemRepository;
import com.example.POS.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public Item updateItem(Long id, Item item) {
        Item existingItem = itemRepository.findById(id).orElse(null);

        if(existingItem != null){
            existingItem.setItemName(item.getItemName());
            existingItem.setPrice(item.getPrice());
            existingItem.setQty(item.getQty());
            existingItem.setCategory(item.getCategory());
            return itemRepository.save(existingItem);
        } else {
            return null;
        }
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
    
}
