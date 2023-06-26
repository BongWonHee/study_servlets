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

@WebServlet(urlPatterns = "/sessionDeleteServlet")
public class SessionDeleteServlet extends HttpServlet {
   // public interface HttpServletRequest extends ServletRequest
   @Override

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try {
         // expired session

         HttpSession httpSession = request.getSession();
         httpSession.invalidate();
         // delete Cookeis
         Cookie[] cookies = request.getCookies(); // 각각의 cookie가 list로 올라옴. 이 각각의 cookies를 hash로 잡아야함

         String content = "<div>CookiesGetAndDeleteServlet</div>";
         for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            if (name.equals("JSESSIONID")) {
               // 쿠키삭제_Client 위치에서
               cookie.setMaxAge(0);
               response.addCookie(cookie);
            }

         }
         PrintWriter printWriter = response.getWriter();
         String contents = "<div>LOGOUT!!</div>";
         printWriter.println(contents);
         printWriter.close();
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
   }
}
