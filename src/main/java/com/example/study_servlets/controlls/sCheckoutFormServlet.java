package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/scheckoutFormServlet")
public class sCheckoutFormServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter printWriter = response.getWriter();
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.css\">\r\n" + //
                    "    <title>Billing</title>\r\n" + //
                    "</head>\r\n" + //
                    "\r\n" + //
                    "<body class=\"bg\">\r\n" + //
                    "\r\n" + //
                    "    <div class=\"h1 text-center m-3 p-3\">Billing address</div>\r\n" + //
                    "    <form action=\"/scheckoutResponseServlet\" method=\"get\">\r\n" + //
                    "    <div class=\"container\">\r\n" + //
                    "        <br>\r\n" + //
                    "        <div class=\"row\">\r\n" + //
                    "            <div class=\"col-6 p-2\">\r\n" + //
                    "                <label for=\"myfirst\">First name </label>\r\n" + //
                    "                <input type=\"text\" name=\"First_name\" , id=\"myfirst\">\r\n" + //
                    "            </div>\r\n" + //
                    "            <div class=\"col-6 p-2\">\r\n" + //
                    "                <label for=\"mylast\">Last name </label>\r\n" + //
                    "                <input type=\"text\" name=\"Last_name\" , id=\"mylast\">\r\n" + //
                    "            </div>\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "            <div class=\"col-12 p-2\">\r\n" + //
                    "                <label for=\"myname\">Username </label>\r\n" + //
                    "                <input type=\"text\" name=\"Username\" , id=\"myname\">\r\n" + //
                    "            </div>\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "            <div class=\"col-12 p-2\">\r\n" + //
                    "                <label for=\"myemail\">Email</label>\r\n" + //
                    "                <input type=\"email\" name=\"Email\" , id=\"myemail\">\r\n" + //
                    "            </div>\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "            <div class=\"col-12 p-2\">\r\n" + //
                    "                <label for=\"myadress\">Address</label>\r\n" + //
                    "                <input type=\"text\" name=\"Address\" , id=\"myadress\">\r\n" + //
                    "            </div>\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "            <div class=\"col-12 p-2\">\r\n" + //
                    "                <label for=\"myadress2\">Address 2 (Optional)</label>\r\n" + //
                    "                <input type=\"text\" name=\"Address2\" , id=\"myadress2\">\r\n" + //
                    "            </div>\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "            <div class=\"col-6 p-2\">\r\n" + //
                    "                <label for=\"mycountry\">Country </label>\r\n" + //
                    "                <select name=\"Country\" id=\"mycountry\">\r\n" + //
                    "                    <option value=\" \">Choosing...</option>\r\n" + //
                    "                    <option value=\"korea\">KOREA</option>\r\n" + //
                    "                    <option value=\"canada\">CANADA</option>\r\n" + //
                    "                    <option value=\"england\">ENGLAND</option>\r\n" + //
                    "                </select>\r\n" + //
                    "            </div>\r\n" + //
                    "            <div class=\"col-4 p-2\">\r\n" + //
                    "                <label for=\"mystate\">State </label>\r\n" + //
                    "                <select name=\"State\" id=\"mystate\">\r\n" + //
                    "                    <option value=\" \">Choosing...</option>\r\n" + //
                    "                    <option value=\"seoul\">SEOUL</option>\r\n" + //
                    "                    <option value=\"ottawa\">OTTAWA</option>\r\n" + //
                    "                    <option value=\"london\">LONDON</option>\r\n" + //
                    "                </select>\r\n" + //
                    "\r\n" + //
                    "            </div>\r\n" + //
                    "            <div class=\"col-2 p-2\">\r\n" + //
                    "                <label for=\"myzip\">Zip </label>\r\n" + //
                    "                <input type=\"text\" name=\"Zip\" , id=\"myzip\">\r\n" + //
                    "            </div>\r\n" + //
                    "\r\n" + //
                    "        </div>\r\n" + //
                    "\r\n" + //
                    "    </div>\r\n" + //
                    "    <div> <button type=\"submit bt-summary\">SEND</button></div>\r\n" + //
                    "</form>\r\n" + //
                    "</body>\r\n" + //
                    "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n" + //
                    "</html>";

            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        }
    }
}
