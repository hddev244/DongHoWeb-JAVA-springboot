package com.hddev244.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hddev244.entity.Brand;
import com.hddev244.repositoy.BrandRepository;
import com.hddev244.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{
      @Autowired
      BrandRepository repository;
      @Override
      public void delete(String id) {
            
      }
      @Override
      public List<Brand> findAll() {
            return repository.findAll();
      }
      @Override
      public Optional<Brand> findById(String id) {
            // TODO Auto-generated method stub
            return repository.findById(id);
      }
      @Override
      public void insert(Brand entity) {
            if (entity != null) {
                  repository.save(entity);  
            }
      }
      @Override
      public void update(Brand entity) {
            // TODO Auto-generated method stub
            
      }
}
