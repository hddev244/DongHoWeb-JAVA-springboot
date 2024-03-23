package com.hddev244.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hddev244.dto.CartItemDTO;
import com.hddev244.entity.Account;
import com.hddev244.entity.CartItem;
import com.hddev244.model.ShoppingCart;
import com.hddev244.service.CartService;
import com.hddev244.service.ShoppingCartService;
import com.hddev244.service.scope.CookieService;
import com.hddev244.service.scope.SessionService;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(value = "api-cart")
public class CartIAPI {
  @Autowired
  CartService cartService;
  @Autowired
  SessionService session;
  @Autowired
  CookieService cookie;
  @Autowired
  ShoppingCartService shoppingCartService;

  @GetMapping
  public List<CartItem> getCarts() {
    Account account = (Account) session.get("account");
    List<CartItem> response = new ArrayList<CartItem>();
    List<ShoppingCart> carts;
    if (account == null) {
      String cartsJson = cookie.getValue("carts");

      if (cartsJson != null) {
        Gson gson = new Gson();
        String decodedJson = URLDecoder.decode(cartsJson, StandardCharsets.UTF_8);
        Type cartListType = new TypeToken<List<ShoppingCart>>() {
        }.getType();
        carts = gson.fromJson(decodedJson, cartListType);
      }
    } else {
      response = cartService.findAllByAccoutId(account.getUsername());
      carts = shoppingCartService.findShopingCartById(account.getUsername());
      if (carts != null) {
        Gson gson = new Gson();
        String json = gson.toJson(carts);
        String encodedJson = URLEncoder.encode(json, StandardCharsets.UTF_8);
        cookie.remove("carts");
        cookie.add("carts", encodedJson, 24 * 10);
      }
    }

    return response;
  }

  // add to cart
  @PostMapping()
  public void postToCart(@RequestParam("productId") Optional<Long> productId) {
    if (productId.isPresent()) {
      Account account = (Account) session.get("account");
      List<ShoppingCart> carts;
      if (account == null) {
        carts = (List<ShoppingCart>) cookie.get("carts");
      } else {
        Long pId = productId.get();
        cartService.addToCart(pId, account.getUsername());
        carts = shoppingCartService.findShopingCartById(account.getUsername());
      }
      Gson gson = new Gson();
      String json = gson.toJson(carts);
      String encodedJson = URLEncoder.encode(json, StandardCharsets.UTF_8);
      cookie.remove("carts");
      cookie.add("carts", encodedJson, 24 * 10);
    }
  }

  @PutMapping("increaseOne")
  public CartItemDTO inCreaseOne(@RequestParam(name = "id", required = false) Optional<Long> id) {
    CartItemDTO dto = new CartItemDTO();
    if (id.isPresent()) {
      Optional<CartItem> cartItem = cartService.increaseOne(id.get());
      if (cartItem.isPresent()) {
        dto.setProduct(cartItem.get().getProduct());
        dto.setId(cartItem.get().getId());
        dto.setQuantity(cartItem.get().getQuantity());
        return dto;
      } else {
        return dto; // Or handle the case when the item is not found
      }
    } else {
      return dto; // Or handle the case when productId is not provided
    }
  }

  @PutMapping("decreaseOne")
  public CartItemDTO deCreaseOne(@RequestParam("id") Optional<Long> id) {
    CartItemDTO dto = new CartItemDTO();
    if (id.isPresent()) {
      Optional<CartItem> cartItem = cartService.decreaseOne(id.get());
      if (cartItem.isPresent()) {
        dto.setProduct(cartItem.get().getProduct());
        dto.setId(cartItem.get().getId());
        dto.setQuantity(cartItem.get().getQuantity());
        return dto;
      } else {
        return dto; // Or handle the case when the item is not found
      }
    } else {
      return dto; // Or handle the case when productId is not provided
    }
  }

  @DeleteMapping
  public void delete(@RequestParam("id") Optional<Long> id) {
    if (id.isPresent()) {
      cartService.delete(id.get());
    }
  }

}
