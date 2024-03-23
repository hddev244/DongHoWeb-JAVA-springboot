package com.hddev244.service;



import java.util.List;

import com.hddev244.entity.Order;
import com.hddev244.entity.OrderDetail;

public interface OrderDetailService extends BaseService<OrderDetail,Long> {
    List<OrderDetail> findByOrder(Order order);
}
