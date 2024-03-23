package com.hddev244.model;


import java.io.Serializable;

import com.hddev244.entity.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ShoppingCart implements Serializable  {
      @Id
      private Long id;
      private String accountId;
      private Long productId;
      private Integer quantity;
}
