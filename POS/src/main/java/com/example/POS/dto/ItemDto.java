package com.example.POS.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
    
    private Long id;
    private String itemName;
    private Double price;
    private Integer qty;
    private Long itemId;
}
