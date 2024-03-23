package com.hddev244.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hddev244.entity.Product;
import com.hddev244.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductAPI {
  @Autowired
  ProductService productService;
  @GetMapping("search")
  public Page<Product> search(@RequestParam(name="keyword",required = false) String keyword){
    System.out.println(keyword);
    return productService.findAllByNameLike(keyword,0,6);
  }
}
