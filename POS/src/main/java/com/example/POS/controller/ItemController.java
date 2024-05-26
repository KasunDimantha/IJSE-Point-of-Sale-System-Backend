package com.example.POS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.POS.dto.ItemDto;
import com.example.POS.entity.Category;
import com.example.POS.entity.Item;
import com.example.POS.service.CategoryService;
import com.example.POS.service.ItemService;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {
    
    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/item")
    public ResponseEntity<Item> addItem(@RequestBody Item item){
        Item newItem = itemService.addItem(item);

        if(newItem != null){
            return ResponseEntity.status(200).body(newItem);
        } else{
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping("/item")
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> items = itemService.getAllItems();

        if(items != null){
            return ResponseEntity.status(200).body(items);
        } else{
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id){
        Item item = itemService.getItemById(id);

        if(item != null){
            return ResponseEntity.status(200).body(item);
        } else{
            return ResponseEntity.status(400).build();
        }
    }

    @PutMapping("/item/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody ItemDto itemDto){
        
        Item item = new Item();

        item.setItemName(itemDto.getItemName());
        item.setPrice(itemDto.getPrice());
        item.setQty(itemDto.getQty());

        Category category = categoryService.getCategoryById(itemDto.getCategoryId());
        item.setCategory(category);

        Item updatedItem = itemService.updateItem(id, item);

        if(updatedItem != null){
            return ResponseEntity.status(200).body(updatedItem);
        } else{
            return ResponseEntity.status(400).build();
        }
    }

    @DeleteMapping("/item/{id}")
    public void deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
    }
}
