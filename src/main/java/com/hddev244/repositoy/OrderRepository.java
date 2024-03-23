package com.hddev244.repositoy;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.hddev244.entity.Order;
import java.util.List;


public interface OrderRepository extends JpaRepository<Order,Long> {
      @Query("Select o from Order o where o.account.username like ?1")
      List<Order> findByAccountId(String accountId);
      
      @Query("Select o from Order o where o.account.username like ?1")
      Page<Order> findPageByAccountId(String accountId,Pageable pageable);
}
