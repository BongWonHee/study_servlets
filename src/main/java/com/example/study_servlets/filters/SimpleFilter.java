package com.example.study_servlets.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.boot.devtools.remote.server.Dispatcher;

// @WebFilter(urlPatterns = "/*") // 모든url을 확인
public class SimpleFilter implements Filter { // Filter는 interface임.

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            System.out.println(request.getRemoteHost());
            System.out.println(request.getRemoteAddr());
           
        
          
            chain.doFilter(request, response);// 필터로 들어온 정보를 해당 url로 다시 보내준다.

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
