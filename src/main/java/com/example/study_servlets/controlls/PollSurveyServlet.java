package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.daos.PollsDao;

@WebServlet(urlPatterns = "/poll/SurveryServlet")
public class PollSurveyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // String contents = "Yoju Lab !";
            String contents = request.getParameter("company");

            // pollsdao 호출하기
            PollsDao pollsDao = new PollsDao();
            ArrayList surveyList = pollsDao.SelectWithSearch(contents); // return되는 type이 중요함.
            String compare = "";
            for (int i = 0; i < surveyList.size(); i = i + 1) {
                HashMap survey = (HashMap) surveyList.get(i);
                String questions = (String) survey.get("t_Q.QUESTIONS");
                String questionsId = (String) survey.get("t_QC.QUESTIONS_ID");
                String choice = (String) survey.get("t_C.CHOICE");
                if (!compare.equals(questionsId)) {
                    System.out.println(questions);
                    System.out.println(choice);
                    compare = questionsId;
                } else {
                    System.out.println(choice);
                }
            }

            request.setAttribute("contents", contents);
            request.setAttribute("surveyList", surveyList);
            // 다음 파일 호출
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/surveys/survey.jsp");

            // browser에 떳던 url을 넣어주는것.
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
