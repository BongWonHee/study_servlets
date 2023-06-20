package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/mynameRequestServlet")
public class MynameRequestServlet extends HttpServlet {
<<<<<<< HEAD
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
=======
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
>>>>>>> 520a0de2f97b2a6e9b86e6328ae7a411f3c8cb0d
        try {
            PrintWriter printWriter = response.getWriter();
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>Document</title>\r\n" + //
                    "</head>\r\n" + //
                    "\r\n" + //
                    "<body>\r\n" + //
                    "    <div>\r\n" + //
                    "        input your name\r\n" + //
                    "    </div>\r\n" + //
                    "    <form action=\"/getRequestParamsServlet\" method=\"get\">\r\n" + //
<<<<<<< HEAD
                    "        <div>\r\n" + //
                    "            first name : <input type=\"text\" name=\"first_name\">\r\n" + //
                    "        </div>\r\n" + //
                    "        <div>\r\n" + //
                    "            second name : <input type=\"text\" name=\"second_name\">\r\n" + //
                    "        </div>\r\n" + //
                    "        <div>\r\n" + //
                    "            <button type=\"submit\">go!!</button>\r\n" + //
                    "        </div>\r\n" + //
=======
                    "        <div> first name : <input type=\"text\" name=\"first_name\"></div>\r\n" + //
                    "        <div> second name : <input type=\"text\" name=\"second_name\"></div>\r\n" + //
                    "        <div> <button type=\"submit\">\uBCF4\uB0B4\uAE30</button></div>\r\n" + //
>>>>>>> 520a0de2f97b2a6e9b86e6328ae7a411f3c8cb0d
                    "    </form>\r\n" + //
                    "</body>\r\n" + //
                    "\r\n" + //
                    "</html>";
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
<<<<<<< HEAD
            System.out.println(e.getMessage());// TODO: handle exception
        }
    }
=======
            System.out.println(e.getMessage());
            // TODO: handle exception
        }

    }

>>>>>>> 520a0de2f97b2a6e9b86e6328ae7a411f3c8cb0d
}
