package com.example.study_servlets.controlls;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.commons.Commons;
import com.example.study_servlets.daos.CarInforsDao;

import com.example.study_servlets.daos.OptioninforsDao;

@WebServlet(urlPatterns = "/optionsInforsJSPServlet") // pattern url형식으로 들어온다.
public class OptionsInforsJSPServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //남은 code는 search만
            String search = request.getParameter("search");

            String contents = "";
            OptioninforsDao optioninforsDao = new OptioninforsDao();
            ArrayList optionInforList = new ArrayList<>();
            optionInforList = optioninforsDao.SeletWhithSearch(search);

            request.setAttribute("search", search);
            request.setAttribute("optionInforList", optionInforList);
            //getWriter하기 전에 characterset을 하기_
            response.setContentType("text/html;charset=UTF-8");

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cars/option_infors.jsp");
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
