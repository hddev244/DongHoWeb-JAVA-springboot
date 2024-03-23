package com.hddev244.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hddev244.entity.Account;
import com.hddev244.entity.CartItem;
import com.hddev244.entity.Product;
import com.hddev244.model.ShoppingCart;

import java.util.List;


public interface CartItemRepository extends JpaRepository<CartItem,Long> {
      @Query("Select c from CartItem c where c.product.id=?1 and c.account.id=?2")
      CartItem findByProduct(Long productId,String userName); 

      @Query("Select c from CartItem c where c.product=?1 and c.account=?2")
      CartItem findByProduct(Product product,Account account); 

      @Query("Select c from CartItem c where c.account=?1")
      List<CartItem> findByAccount(Account account);
      
      @Query("Select c from CartItem c where c.account=?1 and c.product.id=?2")
      List<CartItem> findByAccountAndProduct(Account account, Long productId);
      
      @Query("Select c from CartItem c where c.account=?1 and c.product=?2")
      List<CartItem> findByAccountAndProduct(Account account, Product product);
      
      @Query("Select new ShoppingCart(c.id,c.account.id,c.product.id,c.quantity) from "
             +" CartItem c where  c.account.id=?1")
      List<ShoppingCart> findShopingCartById(String username);

}
