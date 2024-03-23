package com.hddev244.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hddev244.entity.Account;
import com.hddev244.service.AccountService;
import com.hddev244.service.scope.CookieService;
import com.hddev244.service.scope.SessionService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AutheticaionController {
	@Autowired
	SessionService session;
	@Autowired
	CookieService cookie;
	@Autowired
	AccountService accountService;
	@Autowired
	HttpServletRequest request;

	@GetMapping("/login")
	public String getForm(Model model,@RequestParam(name = "error", required = false) String error) {
		String referer = request.getHeader("referer");
		session.set("referer", referer);
    model.addAttribute("error", error);
		model.addAttribute("account", new Account());
		return "pages/login";
	}

	@PostMapping("/account/login")
	public String login(@ModelAttribute("account") Account account, Model model) {
		Optional<Account> accountLogged = accountService.login(account);

		if (accountLogged.isPresent()) {

			model.addAttribute("checkLogged", true);
			model.addAttribute("message", "Đăng nhập thành công!");
			session.set("account", accountLogged.get());

			cookie.add("username", accountLogged.get().getUsername(), 24 * 10);
      if(accountLogged.get().isAdmin())
      {
        return "redirect:/admin";
      }
			String referer = session.get("referer");
			session.remove("referer");
			if (referer != null) {
				return "redirect:" + referer;
			} else {
				return "redirect:/home";
			}

		} else {
			model.addAttribute("account", false);
			model.addAttribute("message", "Đăng nhập thất bại!");
		}
		return "pages/login";
	}

	@GetMapping("/logout")
	public String logout() {
		String referer = request.getHeader("referer");
		session.remove("account");
		return "redirect:" + referer;
	}
}
