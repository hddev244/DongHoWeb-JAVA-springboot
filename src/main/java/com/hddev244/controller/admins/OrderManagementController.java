package com.hddev244.controller.admins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hddev244.entity.Order;
import com.hddev244.model.PathToPage;
import com.hddev244.service.OrderService;

@Controller
@RequestMapping("/admin/order-management")
public class OrderManagementController {
  @Autowired
  OrderService orderService;

  @GetMapping()
  public String get() {
    return "layouts/default-layout";
  }

  @ModelAttribute("orders")
  public Page<Order> getOrders() {
    return orderService.findAll(0, 10);
  }
  
  @ModelAttribute("viewsPage")
  public String getViewPage() {
    return PathToPage.ADMIN_PRODUCT_ORDER;
  }
}
