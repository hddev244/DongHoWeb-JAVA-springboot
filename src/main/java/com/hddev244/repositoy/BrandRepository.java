package com.hddev244.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hddev244.entity.Brand;

public interface BrandRepository  extends JpaRepository<Brand,String> {
      
}
