package com.hddev244.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hddev244.model.InitData;
import com.hddev244.model.Product;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HomeContronller {
	@Autowired
	HttpServletRequest request;

	@GetMapping({ "", "home" })
	public String getHome() {
		if (request.getAttribute("viewsPage") == null)
			request.setAttribute("viewsPage", "/WEB-INF/views/index.jsp");

		return "layouts/default-layout";
	}

	@GetMapping("about")
	public String getAbout() {
		request.setAttribute("viewsPage","/WEB-INF/views/pages/about-page.jsp");
		 return "forward:/home";
	}
	
	@ModelAttribute("products")
	private List<Product> initData() {
		return InitData.getProducts();
	}
}
