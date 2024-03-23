package com.hddev244.controller;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.tags.shaded.org.apache.bcel.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hddev244.entity.Account;
import com.hddev244.entity.CartItem;
import com.hddev244.entity.Product;
import com.hddev244.service.CartService;
import com.hddev244.service.ProductService;
import com.hddev244.service.scope.CookieService;
import com.hddev244.service.scope.SessionService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeContronller {
	@Autowired
	SessionService session;
	@Autowired
      CookieService cookie;
	@Autowired
	ProductService productService;
	@Autowired
	CartService cartService;

	@GetMapping({ "", "home" })
	public String getHome(Model model) {
		if (model.getAttribute("viewsPage") == null)
			model.addAttribute("viewsPage", "/WEB-INF/views/index.jsp");
		return "layouts/default-layout";
	}

	@GetMapping("about")
	public String getAbout(Model model) {
		model.addAttribute("viewsPage","/WEB-INF/views/pages/about-page.jsp");
		return "layouts/default-layout";
	}
	
	@ModelAttribute("products")
	private List<Product> initData() {
		return productService.findAll();
	}
}
