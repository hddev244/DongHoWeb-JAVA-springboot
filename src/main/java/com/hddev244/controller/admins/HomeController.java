package com.hddev244.controller.admins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hddev244.model.ModelAttributeKey;
import com.hddev244.model.PathToPage;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class HomeController {
	@Autowired
	HttpServletRequest request;
	@RequestMapping()
	public String getIndex(Model model) {
		request.setAttribute(ModelAttributeKey.VIEW_PAGE, PathToPage.ADMIN_HOME);
		return "forward:/";
	}
}
