package com.hddev244.service;

import java.util.List;

import com.hddev244.model.ShoppingCart;

public interface ShoppingCartService  {
        public List<ShoppingCart> findShopingCartById(String userName);
}
