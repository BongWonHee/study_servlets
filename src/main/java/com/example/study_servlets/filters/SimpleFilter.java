package com.example.study_servlets.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// @WebFilter(urlPatterns ="/*")
//url로 request가 들어 올때 Webfilter로 통해서 필요 부분의 servlet만 작동하게 한다!!

public class SimpleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {

            // 지나가는 통로 check
            System.out.println(request.getRemoteHost());
            System.out.println(request.getRemoteAddr());
            
            chain.doFilter(request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
