package com.hddev244.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hddev244.entity.Account;
import com.hddev244.entity.CartItem;
import com.hddev244.entity.Order;
import com.hddev244.entity.OrderDetail;
import com.hddev244.repositoy.OrderRepository;
import com.hddev244.service.AccountService;
import com.hddev244.service.CartService;
import com.hddev244.service.OrderDetailService;
import com.hddev244.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
  @Autowired
  CartService cartService;
  @Autowired
  AccountService accountService;
  @Autowired
  OrderDetailService orderDetailService;
  @Autowired
  OrderRepository repository;

  @Override
  public Optional<Order> insert(Order order, Account account) {
    order.setAccount(account);
    Order ordered = repository.save(order);
    if (ordered != null) {
      List<CartItem> cartItems = new ArrayList<CartItem>();
      List<OrderDetail> listDetails = new ArrayList<OrderDetail>();

      cartItems = cartService.findAllByAccoutId(account.getUsername());
      if (!cartItems.isEmpty()) {
        for (CartItem cartItem : cartItems) {
          OrderDetail orderDetail = new OrderDetail();
          orderDetail.setPrice(cartItem.getProduct().getPrice());
          orderDetail.setQuantity(cartItem.getQuantity());
          orderDetail.setProduct(cartItem.getProduct());
          orderDetail.setOrder(ordered);

          orderDetailService.insert(orderDetail);
          listDetails.add(orderDetail);
          cartService.delete(cartItem.getId());
        }
      }
      ordered.setOrderDetails(listDetails);
    }
    return Optional.of(ordered);
  }

  @Override
  public Optional<Order> insert(Order order, String accountId) {
    if (!accountId.equals("") || accountId != null) {
      Optional<Account> account = accountService.findById(accountId);
      if (account.isPresent()) {
        return insert(order, account.get());
      }
    }
    return Optional.empty();
  }

  @Override
  public List<Order> findByAccount(Account account) {

    return null;
  }

  @SuppressWarnings("unused")
  @Override
  public List<Order> findByAccountId(String accountId) {
    if (!accountId.equals("") || accountId != null) {
      return repository.findByAccountId(accountId);
    } else {
      return null;
    }
  }

  @Override
  public Optional<Order> findById(Long id) {
    if (id != null) {
      return repository.findById(id);
    } else {
      return Optional.empty();
    }
  }

  @Override
  public List<Order> findAll() {

    return null;
  }

  @Override
  public Page<Order> findAll(int pageIndex, int size) {
    Pageable pageable = PageRequest.of(pageIndex, size);
    return repository.findAll(pageable);
  }

  @Override
  public Page<Order> findPageByAccountId(String accountId, int pageIndex, int size) {
    Pageable pageable = PageRequest.of(pageIndex, size);
    return repository.findPageByAccountId(accountId, pageable);
  }
}