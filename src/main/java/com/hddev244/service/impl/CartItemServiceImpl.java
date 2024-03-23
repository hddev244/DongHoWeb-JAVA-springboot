package com.hddev244.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hddev244.entity.Account;
import com.hddev244.entity.CartItem;
import com.hddev244.entity.Product;
import com.hddev244.repositoy.CartItemRepository;
import com.hddev244.service.AccountService;
import com.hddev244.service.CartService;
import com.hddev244.service.ProductService;

@Service
public class CartItemServiceImpl implements CartService {
  @Autowired
  private CartItemRepository repository;
  @Autowired
  AccountService accountService;

  @Override
  public void addToCart(Product product, Account account) {
    CartItem cartItem = repository.findByProduct(product, account);

    if (cartItem == null) {
      cartItem = new CartItem();
      cartItem.setProduct(product);
      cartItem.setAccount(account);
      cartItem.setQuantity(1);
    } else {
      cartItem.setQuantity(cartItem.getQuantity() + 1);
    }
    repository.save(cartItem);
  }

  @Override
  public void addToCart(Long id, Account account) {
    CartItem cartItem = repository.findByProduct(id, account.getUsername());

    if (cartItem == null) {
      Product product = new Product();
      product.setId(id);
      cartItem = new CartItem();
      cartItem.setAccount(account);
      cartItem.setProduct(product);
      cartItem.setQuantity(1);
    } else {
      cartItem.setQuantity(cartItem.getQuantity() + 1);
    }

    repository.save(cartItem);
  }

  @Override
  public void addToCart(Long id, String accoutId) {
    Optional<Account> account = accountService.findById(accoutId);
    if (account.isPresent()) {
      addToCart(id, account.get());
    }
  }

  @Override
  public void delete(Long id) {
    if (id != null) {
      repository.deleteById(id);
    }
  }

  @Override
  public Optional<CartItem> findById(Long id) {
    if (id != null) {
      return repository.findById(id);
    } else {
      return Optional.empty();
    }
  }

  @Override
  public List<CartItem> findAll(Account account) {
    return repository.findByAccount(account);
  }

  @Override
  public List<CartItem> findAllByAccoutId(String id) {
    Optional<Account> account = accountService.findById(id);
    if (account.isPresent()) {
      return repository.findByAccount(account.get());
    }
    return null;
  }

  @Override
  public Optional<CartItem> decreaseOne(Long id) {
    if (id != null) {
      Optional<CartItem> item = repository.findById(id);
      if (item.isPresent()) {
        item.get().setQuantity(item.get().getQuantity() - 1);
        if (item.get().getQuantity() < 1) {
          repository.deleteById(id);
        } else {
          repository.save(item.get());
        }
        return item;
      }
    }
    return Optional.empty();
  }

  @Override
  public Optional<CartItem> increaseOne(Long id) {
    System.out.println(id);
    if (id != null) {
      Optional<CartItem> item = repository.findById(id);
      if (item.isPresent()) {
        item.get().setQuantity(item.get().getQuantity() + 1);
        repository.save(item.get());
        return item;
      }
    }
    return Optional.empty();
  }

  @Override
  public Optional<CartItem> decreaseOne(CartItem item) {
    if (item != null) {
      item.setQuantity(item.getQuantity() - 1);
      if (item.getQuantity() < 1) {
        repository.deleteById(item.getProduct().getId());
      } else {
        repository.save(item);
      }
      return Optional.of(item);
    }
    return Optional.empty();
  }

  @Override
  public Optional<CartItem> increaseOne(CartItem item) {
    if (item != null) {
      item.setQuantity(item.getQuantity() + 1);
      repository.save(item);
    }
    return Optional.empty();
  }
}
