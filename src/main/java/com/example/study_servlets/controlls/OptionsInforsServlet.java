package com.example.study_servlets.controlls;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.commons.Commons;
import com.example.study_servlets.daos.CarInforsDao;
import com.example.study_servlets.daos.OptionInforsDao;

@WebServlet(urlPatterns = "/optionsInforsServlet") // pattern url형식으로 들어온다.
public class OptionsInforsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
                        String search = request.getParameter("search");

            String temp = "";
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\">\r\n"
                    + //
                    "\r\n" + //
                    "    <title>Option_information</title>\r\n" + //
                    "</head>\r\n" + //
                    "<body>\r\n" + //
                    "<div class=\"container\">\r\n" + //
                    "        <form action=\"/optionsInforsServlet\" >\r\n" + //
                    "        <!-- method=\"get\"> -->\r\n" + //
                    "        <label for=\"\">\uAC80\uC0C9</label>\r\n" + //
                    "        <input type=\"text\" name=\"search\" value ='"+search+"'>\r\n" + //
                    "        <button>\uAC80\uC0C9 \uD558\uAE30</button>\r\n" + //
                    "        </form>\r\n" + //
                    "    </div>" + //
                    "    <div class=\"container\">\r\n" + //
                    "        <table class=\"table table-bordered table-hover\">\r\n" + //
                    "            <thead>\r\n" + //
                    "                <tr>\r\n" + //
                    "                    <th>OPTION_INFOR_ID</th>\r\n" + //
                    "                    <th>OPTION_NAME</th>\r\n" + //
                    "                </tr>\r\n" + //
                    "            </thead>\r\n" + //
                    "            <tbody>\r\n"; //
            OptionInforsDao optioninforsDao = new OptionInforsDao();
            ArrayList optionInforList = new ArrayList();
            optionInforList = optioninforsDao.SeletWhithSearch(search);

            for (int i = 0; i < optionInforList.size(); i = i + 1) {
                HashMap optionInforRecord = new HashMap<>();
                optionInforRecord = (HashMap) optionInforList.get(i);
                contents = contents + "                <tr>\r\n" + //
                        "                    <td>" + optionInforRecord.get("OPTION_INFOR_ID") + "</td>\r\n" + //
                        "                    <td>" + optionInforRecord.get("OPTION_NAME") + "</td>\r\n" + //
                        "                </tr>\r\n";
            }
            // resultset으로 담아진 결과를 getString으로 받기

            contents = contents + "            </tbody>\r\n" + //
                    "        </table>\r\n" + //
                    "    </div>\r\n" + //
                    "\r\n" + //
                    "</body>\r\n" + //
                    "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
                    + //
                    "\r\n" + //
                    "</html>";
            // getWriter하기 전에 charset하기
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
