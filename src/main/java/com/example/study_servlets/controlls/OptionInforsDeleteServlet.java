package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.commons.Commons;
import com.example.study_servlets.daos.OptionInforsDao;

@WebServlet(urlPatterns = "/optionInforsDeleteServlet")
public class OptionInforsDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String unique_id = request.getParameter("unique_id"); //html에서 클라이언트가 보내온 값을 받는다.
            OptionInforsDao optionInforsDao = new OptionInforsDao();
            int count = optionInforsDao.DeleteWithUniqeID(unique_id);
           
            response.setContentType("text/html;charset=UTF8");
            PrintWriter printWriter = response.getWriter();
            String contents = "Delete count :"+ count ; //클라이언트에게 결과를 송출해준다.
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
