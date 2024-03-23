package com.hddev244.imterceptor;

import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties.Listener.Session;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.hddev244.entity.Account;
import com.hddev244.service.scope.SessionService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AuthInterceptor implements HandlerInterceptor{
    @Autowired
    SessionService sessionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      String uri = request.getRequestURI();
      Account account = (Account) sessionService.get("account");
      String error = "";
      if (account == null) {
        error = "Vui lòng đăng nhập !";
      }
      else if(!account.isAdmin() && uri.startsWith("/admin/")){
        error = "Đăng nhập bị từ chối, bạn không có quyền quản trị";
      }
      if(error.length()  > 0 ){
        error = URLEncoder.encode(error, "UTF-8");
        sessionService.remove("account");
        response.sendRedirect("/login?error=" + error);
        return false;
      }
      return true;
    }
}
