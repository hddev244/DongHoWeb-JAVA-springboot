package com.hddev244.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hddev244.entity.Account;
import com.hddev244.entity.Order;

public interface OrderService {
      public Optional<Order>  insert(Order order, Account account);
      public Optional<Order> insert(Order order, String accountId);
      public Optional<Order> findById(Long id);
      public List<Order> findAll();
      public List<Order> findByAccount(Account account);
      public List<Order> findByAccountId(String accountId);
      public Page<Order> findAll(int pageIndex, int size);
      Page<Order> findPageByAccountId(String accountId,int pageIndex, int size);
}
