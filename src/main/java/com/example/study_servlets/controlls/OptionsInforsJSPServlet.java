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
            String search = request.getParameter("search");       
            OptioninforsDao optioninforsDao = new OptioninforsDao();
            ArrayList optionInforList = new ArrayList();
            optionInforList = optioninforsDao.SeletWhithSearch(search);
            request.setAttribute("search", search);
            request.setAttribute("optionInforList", optionInforList);
            // servlet을 지나가기 때문에 설정해 주자.
            response.setContentType("text/html;charset=UTF-8");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Cars/option_infors.jsp");
            requestDispatcher.forward(request, response);

            // for (int i = 0; i < optionInforList.size(); i = i + 1) {
            //     HashMap optionInforRecord = new HashMap<>();
            //     optionInforRecord = (HashMap) optionInforList.get(i);
            //     // contents = contents + " <tr>\r\n" + //
            //     // " <td>" + optionInforRecord.get("OPTION_INFOR_ID") + "</td>\r\n" + //
            //     // " <td>" + optionInforRecord.get("OPTION_NAME") + "</td>\r\n" + //
            //     // " </tr>\r\n";
            // }

            
            // PrintWriter printWriter = response.getWriter();
            // printWriter.println(contents);
            // printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
