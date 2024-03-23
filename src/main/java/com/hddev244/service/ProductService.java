package com.hddev244.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hddev244.entity.Product;

public interface ProductService extends BaseService <Product,Long> {
      Page<Product> findByPrice(double min,double max,int pageNumber,int pageSize);
      List<Product> findByPrice(double min,double max);
      Page<Product> findByName(String keyword,int pageNumber,int pageSize);
      List<Product> findByPriceBetween(double minPrice, double maxPrice); 
      Page<Product> findAllByNameLike(String keywords,int pageNumber,int pageSize);
}
