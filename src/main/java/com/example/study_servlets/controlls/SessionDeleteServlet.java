package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = ("/session/DeleteServlet"))
public class SessionDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            // expired session
            HttpSession httpSession = request.getSession();
            httpSession.invalidate(); // jesession 삭제됨
            // cookie 는 hashmap으로 들어온다.
            // delete session으로 들어온다.
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                // String values = cookie.getValue();
                // 쿠키삭제
                if (name.equals("JSESSIONID")) { // 쿠키 삭제 - Client side delete
                    // 쿠키삭제
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }

            response.setContentType("text/html;charset=UTF8");
            PrintWriter printWriter = response.getWriter();
            String content = "<div>Logout</div>";
            printWriter.println(content);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
