package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/helloWorldJSPServlet")
public class HelloWorldJSPServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            // 클라이언트에게 네트워크를 통해서 전송 하는 것

            String contents = "Yoju Lab !";
            request.setAttribute("contents", contents);
            // 다음 파일 호출 하자.
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/HelloWorldJSP.jsp");
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
