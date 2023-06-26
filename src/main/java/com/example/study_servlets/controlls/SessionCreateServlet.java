package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/session/CreateServlet")
public class SessionCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // get parameter from query
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // display
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<div>Create Session Servlets</div>");
            // login
            HttpSession httpSession = request.getSession(false);
            if (httpSession != null) {
                // JSESSION 있음 : 기존 내용만 표시=로그인 됨.
                // (pw는 가져올 필요없음. client에게 보여지는거니까..??)
                String nameSession = (String) httpSession.getAttribute("username");
                printWriter.println("<div> Username : " + nameSession + "</div>");

            } else {// JSESSION 없음 : login을 해야한다.
                if ("yoju".equals(username) && "1234".equals(password)) {
                    httpSession = request.getSession();
                    httpSession.setAttribute("username", username);
                    httpSession.setAttribute("password", password);
                    printWriter.println("<div>" + username + ", " + password + "</div>");
                } else {
                    printWriter.println("<div>Faild</div>");
                }
            }

            printWriter.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
