package com.hddev244.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hddev244.model.Account;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AutheticaionController {
	@Autowired
	HttpSession session;
	@Autowired
	HttpServletResponse response;
	@Autowired
	HttpServletRequest request;

	@GetMapping("/login")
	public String getForm(@ModelAttribute("account") Account account) {
		return "pages/login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("account") Account account, Model model) {
		String username = "user";
		String password = "123";
		if (username.equals(account.getUsername()) && password.equals(account.getPassword())) {	
			model.addAttribute("loged", true);
			model.addAttribute("message", "Đăng nhập thành công!");
			session.setAttribute("account", account );
		} else {
			model.addAttribute("loged", false);
			model.addAttribute("message", "Đăng nhập thất bại!");
		}
		return "pages/login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		String referer = request.getHeader("referer");
		session.removeAttribute("account");
		return "redirect:"+referer;
		}
}
