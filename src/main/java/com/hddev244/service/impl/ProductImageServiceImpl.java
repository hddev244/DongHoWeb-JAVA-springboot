package com.hddev244.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hddev244.entity.ProductImage;
import com.hddev244.repositoy.ProductImageRepository;
import com.hddev244.service.ProductImageService;
import com.hddev244.utils.FileUtil;

@Service
public class ProductImageServiceImpl implements ProductImageService {
      @Autowired
      private ProductImageRepository repository;
      @Autowired
      private FileUtil fileUtil;

      @Override
      public void delete(Long id) {
            if (id != null) {
                  Optional<ProductImage> productImage = repository.findById(id);
                  if (productImage.isPresent()) {
                        fileUtil.deleteImage(productImage.get().getUrl());
                        repository.deleteById(id);
                  }
            }
      }

      @Override
      public List<ProductImage> findAll() {
            return repository.findAll();
      }

      @Override
      public Optional<ProductImage> findById(Long id) {
            if (id != null)
                  return repository.findById(id);
            return null;
      }

      @Override
      public void insert(ProductImage entity) {
            if (entity != null) {
                  repository.save(entity);
            }
      }

      @Override
      public void update(ProductImage entity) {
            insert(entity);
      }
}
