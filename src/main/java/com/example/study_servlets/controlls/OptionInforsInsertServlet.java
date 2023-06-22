package com.example.study_servlets.controlls;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.example.study_servlets.commons.Commons;

import com.example.study_servlets.daos.OptioninforsDao;

@WebServlet(urlPatterns = "/optionInforsInsertServlet")
public class OptionInforsInsertServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = requset.getParameter("name");
            OptioninforsDao optionInforsDao = new OptioninforsDao();
            int count = optionInforsDao.InsertWithCarInfos(name);
             response.setContentType("text/html;charset=UTF8");
            PrintWriter printWriter = response.getWriter();
            String contents = "Insert count :"+ count ; //클라이언트에게 결과를 송출해준다.
            printWriter.println(contents);
            printWriter.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

// import com.example.study_servlets.daos.OptioninforsDao;

// @WebServlet(urlPatterns = "/optionInforsInsertServlet")
// public class OptionInforsInsertServlet extends HttpServlet {
//     @Override
//     protected void doGet(HttpServletRequest request, HttpServletResponse response)
//             throws ServletException, IOException {

//         try {
//             // insert를 위한 method만들기_OptioninforsDao에 만들자.
//             String name = request.getParameter("name");
//             OptioninforsDao insertionOption = new OptioninforsDao();
//             int count = insertionOption.InsertWithName(name);

//             // response print하기
//             response.setContentType("text/html;charset=UTF-8");
//             PrintWriter printwriter = response.getWriter();
//             String result = "Insert count: "+ count;
//             printwriter.println(result);
//             printwriter.close();
//         } catch (Exception e) {
//             System.out.println(e.getMessage());
//         }

//     }

// }