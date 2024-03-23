package com.hddev244.service;

import java.util.List;
import java.util.Optional;

import com.hddev244.entity.Account;
import com.hddev244.entity.CartItem;
import com.hddev244.entity.Product;

public interface CartService { 
      public void addToCart(Product product,Account account);
      public void addToCart(Long id,Account account);
      public void addToCart(Long id,String accoutId);
      public void delete(Long id);
      public Optional<CartItem> findById(Long id);
      public List<CartItem> findAll(Account account);
      public List<CartItem> findAllByAccoutId(String id);
      public Optional<CartItem> decreaseOne(Long id);
      public Optional<CartItem> increaseOne(Long id);
      public Optional<CartItem> decreaseOne(CartItem item);
      public Optional<CartItem> increaseOne(CartItem item);
}
