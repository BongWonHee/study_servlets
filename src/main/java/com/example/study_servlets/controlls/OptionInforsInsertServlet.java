package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.daos.OptioninforsDao;

@WebServlet(urlPatterns = "/optionInforsInsertServlet")
public class OptionInforsInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // insert를 위한 method만들기_OptioninforsDao에 만들자.
            String name = request.getParameter("name");
            OptioninforsDao insertionOption = new OptioninforsDao();
            int count = insertionOption.InsertWithName(name);

            // response print하기
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter printwriter = response.getWriter();
            String result = "Insert count: "+ count;
            printwriter.println(result);
            printwriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}