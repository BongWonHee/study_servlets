package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/getRequestParamsServlet")
public class GetRequestParamsServley extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String firstName = request.getParameter("first_name");
            String secondName = request.getParameter("second_name");
            // 클라이언트에게 네트워크를 통해서 전송 하는 것
            PrintWriter printWriter = response.getWriter();
            String contents = "Bong WonHee !";
            contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>Hello World !!!</title>\r\n" + //
                    "</head>\r\n" + //
                    "\r\n" + //
                    "<body>\r\n" + //
                    "    <div>\r\n" + //
                    "        first Name : " + firstName + "\r\n" + //
                    "    </div>\r\n" + //
                    "    <div>\r\n" + //
                    "        second Name : " + secondName + "\r\n" + //
                    "    </div>\r\n" + //
                    "\r\n" + //
                    "</body>\r\n" + //
                    "\r\n" + //
                    "</html>";
            printWriter.println(contents);
            printWriter.close();
            // PrintWriter printWriter = response.getWriter();
            // String contents = "";
            // printWriter.println(contents);
            // printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
