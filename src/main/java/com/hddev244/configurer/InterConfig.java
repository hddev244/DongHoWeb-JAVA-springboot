package com.hddev244.configurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hddev244.imterceptor.AuthInterceptor;

@Configuration
public class InterConfig implements WebMvcConfigurer {
  @Autowired
  AuthInterceptor auth;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(auth)
        .addPathPatterns("/account/edit",
            "/account/chgpwd", "/order/**", "/admin/**","/cart/**")
        .excludePathPatterns("/assets/**", "/admin/home/index");
  }
}
