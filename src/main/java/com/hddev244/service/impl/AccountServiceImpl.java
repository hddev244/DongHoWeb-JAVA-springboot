package com.hddev244.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hddev244.entity.Account;
import com.hddev244.repositoy.AccountRepository;
import com.hddev244.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
      @Autowired
      private AccountRepository repository;

      @Override
      public void insert(Account entity) {
            if (entity != null) {
                  repository.save(entity);
            }
      }

      @Override
      public void update(Account entity) {
            insert(entity);
      }

      @Override
      public void delete(String id) {
            if (id != null) {
                  repository.deleteById(id);
            }
      }

      @Override
      public Optional<Account> findById(String id) {
            if (id != null) {
                  return repository.findById(id);
            } else {
                  return Optional.empty();
            }
      }

      @Override
      public List<Account> findAll() {
            return repository.findAll();
      }

      @Override
      public Optional<Account> login(Account account) {
            if (account != null) {
                  Optional<Account> accountFound = findById(account.getUsername());
                  if (accountFound.isPresent()) {
                        if (accountFound.get().getPassword().equals(account.getPassword())) {
                              return accountFound;
                        } else {
                              return Optional.empty();
                        }
                  } else {
                        return Optional.empty();
                  }
            }
            return Optional.empty();
      }

      /**
       * @param account
       * @return account created
       */
      @Override
      public Optional<Account> register(Account account) {
            if (account != null) {
                  Optional<Account> accountCheck = repository.findById(account.getUsername());
                  if (accountCheck.isPresent()) {
                        return Optional.empty();
                  } else {
                        repository.save(account);
                        return repository.findById(account.getUsername());
                  }
            }
            return Optional.empty();
      }
}
