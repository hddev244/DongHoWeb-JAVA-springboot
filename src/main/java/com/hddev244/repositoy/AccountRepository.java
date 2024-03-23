package com.hddev244.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hddev244.entity.Account;

public interface AccountRepository extends JpaRepository<Account,String> {
      
}
