package com.hddev244.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hddev244.entity.Product;
import com.hddev244.repositoy.ProductRepository;
import com.hddev244.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
      @Autowired
      ProductRepository repository;

      @Override
      public void insert(Product entity) {
            if (entity != null)
                  repository.save(entity);
      }
      @Override
      public void update(Product entity) {
            if (entity != null)
                  repository.save(entity);
      }
      @Override
      public void delete(Long id) {
            repository.deleteById(id);
      }
      @Override
      public List<Product> findAll() {
            return repository.findAll();
      }

      @Override
      public Optional<Product> findById(Long id) {
            if (id != null) 
                  return repository.findById(id);
            return null;
      }
      @Override
      public Page<Product> findByPrice(double min,double max,int pageNumber,int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize);
            return repository.findByPrice(min,max,pageable);
      }
      @Override
      public List<Product> findByPrice(double min,double max) {
            if(min > max){
                  max+=min;
                  min = max - min;
                  max -= min;
            }
            List<Product> products = repository.findByPrice(min,max);
            return products;
      }
      @Override
      public Page<Product> findByName(String keyword,int pageNumber,int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize);
            return repository.findByName("%"+keyword+"%",pageable);
      }

      @Override
      public List<Product> findByPriceBetween(double minPrice, double maxPrice) {
            return repository.findByPriceBetween(minPrice, maxPrice);
      }

      @Override
      public Page<Product> findAllByNameLike(String keywords,int pageNumber,int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize);
            return repository.findAllByNameLike("%"+keywords+"%",pageable);
      }
}
