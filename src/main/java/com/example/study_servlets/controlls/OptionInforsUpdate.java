package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.daos.OptionInforsDao;

@WebServlet(urlPatterns = "/optionInforsUpdateServlet")
public class OptionInforsUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // update를 위한 method_

            String uniqueID = request.getParameter("uniqueID");
            String changename = request.getParameter("changename");

            OptionInforsDao update = new OptionInforsDao();
            int count = update.UpdateWithCarInfos(changename);
            update.UpdateWithCarInfos(getServletName());
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter printwriter = response.getWriter();
            printwriter.println();
            printwriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
