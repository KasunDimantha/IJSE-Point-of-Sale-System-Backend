package com.example.POS.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {
    
    private Long id;
    private Long orderId;
    private Long itemId;
    private Double orderQty;
    private Double itemPrice;
    private Double totalPrice;

}
