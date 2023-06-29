package com.example.study_servlets.controlls;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.daos.PollsDao;

import ch.qos.logback.core.pattern.FormatInfo;

@WebServlet(urlPatterns = "/poll/surveyDone")
public class PollsurveyDone extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HashMap<String, Object> map = new HashMap<String, Object>();

            Enumeration<String> enumber = request.getParameterNames();
            // print 파라미터들
            while (enumber.hasMoreElements()) {
                String key = enumber.nextElement().toString();
                String value = request.getParameter(key);

                map.put(key, value);
                System.out.println(key + "," + value);

            }
            PollsDao pollsDao = new PollsDao();
            pollsDao.Insert(map);
            for (String key : map.keySet()) { // 해쉬맵의 키뭉치를 key로 받아서 주는것
                System.out.println(key + ", " + map.get(key));
            }
            // 다음 파일 호출
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/simples.jsp");
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("HelloWorldServlet - doGet() done.");
    }

}
