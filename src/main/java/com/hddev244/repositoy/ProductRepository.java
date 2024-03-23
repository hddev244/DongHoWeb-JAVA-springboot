package com.hddev244.repositoy;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hddev244.entity.Product;
import com.hddev244.model.Report;
import com.hddev244.model.ReportRevenue;

public interface ProductRepository extends JpaRepository<Product, Long> {
  @Query("SELECT o FROM Product o WHERE o.price BETWEEN ?1 AND ?2")
  List<Product> findByPrice(double minPrice, double maxPrice);

  @Query("SELECT o FROM Product o WHERE o.price BETWEEN ?1 AND ?2")
  Page<Product> findByPrice(double minPrice, double maxPrice, Pageable pageable);

  @Query("SELECT o FROM Product o WHERE o.name LIKE ?1")
  Page<Product> findByName(String keyword, Pageable pageable);

  @Query("SELECT new Report(o.brand,sum(o.price), count(o)) "
      + " FROM Product o "
      + " GROUP BY o.brand "
      + " ORDER BY sum(o.price) DESC ")
  List<Report> getInventoryByBrand();

  @Query("SELECT new ReportRevenue(o.product , sum(o.price), count(o)) "
      + " FROM OrderDetail o "
      + " where o.order.deliverySatus = false "
      + " GROUP BY o.product "
      )
  List<ReportRevenue> getRevenues();

  List<Product> findByPriceBetween(double minPrice, double maxPrice);

  Page<Product> findAllByNameLike(String keywords, Pageable pageable);

}
