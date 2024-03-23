package com.hddev244.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hddev244.model.ShoppingCart;
import com.hddev244.repositoy.CartItemRepository;
import com.hddev244.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
      @Autowired
      CartItemRepository cartItemRepository;

      @Override
      public List<ShoppingCart> findShopingCartById(String username) {
            return cartItemRepository.findShopingCartById(username);
      }
}
