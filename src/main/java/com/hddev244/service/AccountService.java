package com.hddev244.service;

import java.util.Optional;

import com.hddev244.entity.Account;

public interface AccountService extends BaseService<Account,String> {
      Optional<Account> register(Account account);
      Optional<Account> login(Account account);
}
