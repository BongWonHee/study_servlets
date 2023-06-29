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
            //QUESTIONS_ID 와 값을 비교하는 조건문.
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
//상아_Dao로 가져온 DB의 KEY, VALUE 이름과 Dao의 Method?이름이 다름. 
// @WebServlet(urlPatterns = "/poll/SurveryServlet")
// public class PollSurveyServlet extends HttpServlet {
//     protected void doGet(HttpServletRequest request, HttpServletResponse response)
//             throws ServletException, IOException {
//         try {
//             // String contents = "Yoju Lab !";
//             String contents = request.getParameter("company");

//             // pollsdao 호출하기
//             PollsDao pollsDao = new PollsDao();
//             ArrayList surveyList = pollsDao.SelectWithSearch(contents); // return되는 type이 중요함.
//             String compare = "";
//             for (int i = 0; i < surveyList.size(); i = i + 1) {
//                 HashMap survey = (HashMap) surveyList.get(i);
//                 String questions = (String) survey.get("t_Q.QUESTIONS");
//                 String questionsId = (String) survey.get("t_QC.QUESTIONS_ID");
//                 String choice = (String) survey.get("t_C.CHOICE");
//                 if (!compare.equals(questionsId)) {
//                     System.out.println(questions);
//                     System.out.println(choice);
//                     compare = questionsId;
//                 } else {
//                     System.out.println(choice);
