package com.hddev244.service;

import java.util.List;
import java.util.Optional;

public interface BaseService <T,ID> {
      void insert(T entity);
      void update(T entity);
      void delete(ID id);
      Optional<T> findById(ID id);
      List<T> findAll();
}
