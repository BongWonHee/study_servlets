package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cookies/CreateServlet")
public class CookiesCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // cookie에 관한 것
            Cookie cookie_first = new Cookie("firstName", "Wonhee!!");
            Cookie cookie_second = new Cookie("secondName", "Bong");

            response.addCookie(cookie_first);
            response.addCookie(cookie_second);

            // display
            response.setContentType("text/html;charsetUTF=8");
            PrintWriter printWriter = response.getWriter();
            String contents = "<div>CreateCookeServlets</div>";
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
