package com.hddev244.dto;

import com.hddev244.entity.Account;
import com.hddev244.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {
      private Long id;
      private Product product;
      private Integer quantity;
}
