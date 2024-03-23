package com.hddev244.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hddev244.entity.Product;
import com.hddev244.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	HttpServletRequest request;
	@Autowired
	ProductService productService;

	@GetMapping()
	public String getProduct(Model model) {
		request.setAttribute("viewsPage", "/WEB-INF/views/pages/product-page.jsp");
		return "layouts/default-layout";
	}

	@GetMapping("man")
	public String getProductMan(Model model) {
		model.addAttribute("genderSpecific", "Đồng hồ nam");
		return "forward:/product";
	}

	@GetMapping("woman")
	public String getProductWoman(Model model) {
		model.addAttribute("genderSpecific", "Đồng hồ Nữ");
		return "forward:/product";
	}

	@ModelAttribute("products")
	private List<Product> initData() {
		return productService.findAll();
	}
}
