package com.hddev244.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/product/detail")
public class ProductDetailController {
	@Autowired
	HttpServletRequest request;
	@GetMapping
	public String getDetail() {
		request.setAttribute("viewsPage","/WEB-INF/views/pages/detail-page.jsp");
		return "forward:/";
	}
	
}
