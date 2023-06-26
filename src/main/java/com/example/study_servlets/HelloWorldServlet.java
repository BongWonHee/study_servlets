package com.example.study_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/helloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("HelloWorldServlet - doGet() done.");

        try {
            response.setContentType("text/html;charset=UTF8");
            String firstName = "WonHee";
            String secondName = "Bong";
            // 클라이언트에게 네트워크를 통해서 전송 하는 것

            response.setContentType("text/html;charset=UTF8");
            PrintWriter printWriter = response.getWriter();
            String contents = "Yoju lab !";
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("HelloWorldServlet - doGet() done.");
    }

}
