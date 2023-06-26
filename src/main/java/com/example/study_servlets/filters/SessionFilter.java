package com.example.study_servlets.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// @WebFilter(urlPatterns = "/*") // 모든url을 확인
public class SessionFilter implements Filter { // Filter는 interface임.

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            System.out.println(request.getRemoteHost());
            System.out.println(request.getRemoteAddr());

            //클라이언트의 요청 사항을 확인하여 조건이 맞지 않으면 다시 확인함.
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/helloWorldServlet");
            requestDispatcher.forward(request, response);

            // chain.doFilter(request, response);// 필터로 들어온 정보를 해당 url로 다시 보내준다.

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
