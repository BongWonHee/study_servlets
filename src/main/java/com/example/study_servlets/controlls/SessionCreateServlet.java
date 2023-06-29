package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
// username = yojulab&password=1234 
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
            
            // login 할때 jsession 있는지 판단해서 있으면 만들지 않고 없으면 만들어줌.
            HttpSession httpSession = request.getSession(false);
            String usernamesession = (String)httpSession.getAttribute("username");
            if (httpSession != null && usernamesession != null) { // jsession 있음 로그인 됨
                
                printWriter.println("<div>username : " + usernamesession + "</div>");

            } else { // jsession 없음 로그인이 안됨.
                if ("yojulab".equals(username) && "1234".equals(password)) {
                    httpSession = request.getSession();// 방어코드 임.
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
