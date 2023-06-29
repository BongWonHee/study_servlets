package com.example.study_servlets.controlls;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.daos.PollsDao;

@WebServlet(urlPatterns = "/poll/SurveyServlet")
public class PollSurveyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            // String contents = "hello";
            String contents = request.getParameter("company");
            // client 에 들어온 url을 받아 여기 있는 변수의 contensts를
            // JSP로 호출하여 변수를 넘겨준다.
            // 결국 client에게 표시
            PollsDao pollsDao = new PollsDao();
            ArrayList surveyList = pollsDao.SeletWhithSearch(contents);
            HashMap survey = new HashMap<>();
            String compare = "";
            for (int i = 0; i < surveyList.size(); i = i + 1) {
                survey = new HashMap<>();
                survey = (HashMap) surveyList.get(i);
                String question = (String) survey.get("QUESTIONS");
                String questionid = (String) survey.get("QUESTIONS_ID");
                String choice = (String) survey.get("CHOICE");
            
                if (!compare.equals(questionid)) {
                    System.out.println(question);
                    System.out.println(choice + " ");
                    compare = questionid;

                } else {
                    System.out.println(choice + " ");
                }
            }

            request.setAttribute("contents", contents);
            request.setAttribute("surveyList", surveyList);

            // 다음 파일 호출
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/surveys/survey.jsp");
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("HelloWorldServlet - doGet() done.");
    }
}
