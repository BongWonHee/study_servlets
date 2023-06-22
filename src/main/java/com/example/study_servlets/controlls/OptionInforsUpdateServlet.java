package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.commons.Commons;
import com.example.study_servlets.daos.OptioninforsDao;


@WebServlet(urlPatterns = "/optionInforsUpdateServlet")
public class OptionInforsUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int count = 0;
            
            String name = request.getParameter("name");
            OptioninforsDao optionInforsDao = new OptioninforsDao();
          
            count = optionInforsDao.UpdateWithCarInfos(name);
            



            response.setContentType("text/html;charset=UTF8");
            PrintWriter printWriter = response.getWriter();
            String contents = "UPDATE count :" + count; // 클라이언트에게 결과를 송출해준다.
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
