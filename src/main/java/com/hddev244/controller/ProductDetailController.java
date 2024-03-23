package com.hddev244.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hddev244.entity.Product;
import com.hddev244.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("/product/detail")
public class ProductDetailController {
	@Autowired
	HttpServletRequest request;
	@Autowired
	ProductService productService;

	@GetMapping()
	public String getDetail(@RequestParam(value = "id", defaultValue = "0") Optional<Long> id,
			Model model) {
		Long idEdit = id.get().longValue();
		Optional<Product> product = productService.findById(idEdit);
		model.addAttribute("product", product.get());
		return "layouts/default-layout";
	}

	@ModelAttribute("viewsPage")
	public String viewPage() {
		return "/WEB-INF/views/pages/detail-page.jsp";
	}

}
