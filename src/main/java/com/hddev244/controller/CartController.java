package com.hddev244.controller;

import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hddev244.entity.Account;
import com.hddev244.entity.CartItem;
import com.hddev244.entity.Order;
import com.hddev244.model.ShoppingCart;
import com.hddev244.service.AccountService;
import com.hddev244.service.CartService;
import com.hddev244.service.OrderService;
import com.hddev244.service.ShoppingCartService;
import com.hddev244.service.scope.CookieService;
import com.hddev244.service.scope.SessionService;

@Controller
@RequestMapping("cart")
public class CartController {
  @Autowired
  CartService cartService;
  @Autowired
  SessionService session;
  @Autowired
  CookieService cookie;
  @Autowired
  ShoppingCartService shoppingCartService;
  @Autowired
  AccountService accountService;
  @Autowired
  OrderService orderService;

  @GetMapping
  public String getCart(Model model) {
    return "layouts/default-layout";
  }

  @ModelAttribute("viewsPage")
  public String viewPage() {
    return "/WEB-INF/views/pages/cart-page.jsp";
  }

  @ModelAttribute("carts")
  private List<CartItem> initCartItems() {
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
  // @ModelAttribute("orders")
  // public Page<Order> getOrders() {
  // return orderService.findAll(0, 10);
  // }

  @ModelAttribute("orders")
      private Page<Order> getOrders() {
            Account account = (Account) session.get("account");
           if(account != null) {
            Page<Order> orders = orderService.findPageByAccountId(account.getUsername(),0,10);
            return orders;
           }else {
            return  null;
            }
      }
}
