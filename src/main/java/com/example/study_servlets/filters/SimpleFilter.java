package com.example.study_servlets.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// 무조건 거쳐서 서블렛으로 들어가게 하는 것
//@WebFilter(urlPatterns = "/*") 
public class SimpleFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
       try {
            System.out.println(request.getRemoteHost());
            System.out.println(request.getRemoteAddr());
            chain.doFilter(request, response); // 가고 싶은 필터와 연결시켜주는 코드 
       } catch (Exception e) {
        System.out.println(e.getMessage());
       }
    }
    
}
