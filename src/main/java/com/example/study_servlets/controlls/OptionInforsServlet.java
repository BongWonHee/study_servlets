package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.commons.Commons;

import com.example.study_servlets.daos.OptioninforsDao;

@WebServlet(urlPatterns = "/optionInforsServlet")
public class OptionInforsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            String search = request.getParameter("search");
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>Option_Infos</title>\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\">\r\n"
                    + //
                    "</head>\r\n" + //
                    "\r\n" + //
                    "<body>\r\n" + //
                    "<div class=\"container\">\r\n" + //
                    "        <form action=\"/optionInforsServlet\">\r\n" + //
                    "            <label for=\"go\">\uAC80\uC0C9</label>\r\n" + //
                    "            <input type=\"text\" name=\"search\" value=\"" + search + "\" id=\"go\">\r\n" + //
                    "            <button type=\"submit\" class=\"bg-gray\">\uAC80\uC0C9\uD558\uAE30</button>\r\n" + //
                    "            \r\n" + //
                    "        </form>\r\n" + //
                    "    </div>" +
                    "    <div class=\"container\">\r\n" + //
                    "        <table class=\"table table-bordered table-hover\">\r\n" + //
                    "            <thead>\r\n" + //
                    "                <tr>\r\n" + //
                    "                    <th>OPTION_INFOR_ID</th>\r\n" + //
                    "                    <th>OPTION_NAME</th>\r\n" + //
                    "                </tr>\r\n" + //
                    "            </thead>\r\n" + //
                    "            <tbody>\r\n"; //
            OptioninforsDao optionInforsDao = new OptioninforsDao();
            ArrayList optionInforList = new ArrayList();

            optionInforList = optionInforsDao.SeletWhithSearch(search);

            for (int i = 0; i < optionInforList.size(); i++) {
                HashMap optionInforRecord = new HashMap<>();
                optionInforRecord = (HashMap) optionInforList.get(i);
                contents = contents + " <tr>\r\n" +
                        "<td>" + optionInforRecord.get("OPTION_INFOR_ID") + "</td>\r\n" + //
                        "<td>" + optionInforRecord.get("OPTION_NAME") + "</td>\r\n" +
                        "</tr>\r\n";

            }

            contents = contents + "            </tbody>\r\n" + //
                    "        </table>\r\n" + //
                    "    </div>\r\n" + //
                    "\r\n" + //
                    "</body>\r\n" + //

                    "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
                    + //
                    "</html>";
            // 한글이 깨지는 경우에 추가하여 넣어 주어야한다. PrintWriter 위에 넣는다.
            response.setContentType("text/html;charset=UTF-8");

            PrintWriter printWriter = response.getWriter();
            printWriter.println(contents);
            printWriter.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}