package com.hddev244.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hddev244.entity.Account;
import com.hddev244.entity.Order;
import com.hddev244.entity.OrderDetail;
import com.hddev244.entity.Product;
import com.hddev244.service.OrderService;
import com.hddev244.service.ProductService;
import com.hddev244.service.scope.SessionService;

@Controller
@RequestMapping("/order")
public class OrderController {
  @Autowired
  OrderService orderService;
  @Autowired
  SessionService session;
  @Autowired
  ProductService productService;

  @PostMapping
  public String save(Order order, Model model, RedirectAttributes redirectAttributes) {
    Account account = (Account) session.get("account");
    if (account != null) {
      Optional<Order> ordered = orderService.insert(order, account.getUsername());
      if (ordered.isPresent()) {
        model.addAttribute("ordered", ordered.get());
        model.addAttribute("message_order", "Đặt hàng thành công");
      } else {
        model.addAttribute("message_order", "Đặt hàng thất bại!");
      }
    }
    return "layouts/default-layout";
  }

  @GetMapping
  public String getCart() {
    return "layouts/default-layout";
  }

  @ModelAttribute("viewsPage")
  public String viewPage() {
    return "/WEB-INF/views/pages/order-success.jsp";
  }

}
