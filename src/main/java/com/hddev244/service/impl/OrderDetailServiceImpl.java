package com.hddev244.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hddev244.entity.Order;
import com.hddev244.entity.OrderDetail;
import com.hddev244.repositoy.OrderDetialRepository;
import com.hddev244.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
      @Autowired
      private OrderDetialRepository repository;

      @Override
      public void insert(OrderDetail entity) {
            if (entity != null) {
                  repository.save(entity);
            }
      }

      @Override
      public void delete(Long id) {

      }

      @Override
      public List<OrderDetail> findAll() {

            return repository.findAll();
      }

      @Override
      public Optional<OrderDetail> findById(Long id) {
            if (id != null) {
                  return repository.findById(id);
            } else {

                  return Optional.empty();
            }
      }

      @Override
      public void update(OrderDetail entity) {

      }
      @Override
      public List<OrderDetail> findByOrder(Order order) {
            return new ArrayList<OrderDetail>();
      }
}
