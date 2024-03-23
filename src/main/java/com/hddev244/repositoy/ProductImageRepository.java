package com.hddev244.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hddev244.entity.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage,Long> {
      
}
