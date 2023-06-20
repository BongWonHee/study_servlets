package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/checkoutFormServlet")
public class CheckoutFormServlet extends HttpServlet {
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
                    "    <title>CheckForm</title>\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\">\r\n" + //
                    "</head>\r\n" + //
                    "\r\n" + //
                    "<body>\r\n" + //
                    "\r\n" + //
                    "    <form action=\"/checkoutResponseServlet\" method=\"get\">\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "        <div class=\"h1 text-center pt-5\">ChecK Form</div>\r\n" + //
                    "        <div class=\"container pt-5\">\r\n" + //
                    "            <div class=\"h4\">Billing address</div>\r\n" + //
                    "            <div class=\"row\">\r\n" + //
                    "                <div class=\"col-6\">\r\n" + //
                    "\r\n" + //
                    "                    <label class=\"form-label\">First name</label>\r\n" + //
                    "                    <input type=\"text\" class=\"form-control\" name=\"firstname\">\r\n" + //
                    "                </div>\r\n" + //
                    "                <div class=\"col-6\">\r\n" + //
                    "\r\n" + //
                    "                    <label class=\"form-label\">Last name</label>\r\n" + //
                    "                    <input type=\"text\" class=\"form-control\" name=\"lastname\">\r\n" + //
                    "                </div>\r\n" + //
                    "            </div>\r\n" + //
                    "            <div class=\"col-12\">\r\n" + //
                    "\r\n" + //
                    "                <label class=\"form-label\">Username</label>\r\n" + //
                    "                <input type=\"text\" class=\"form-control\" name=\"username\">\r\n" + //
                    "            </div>\r\n" + //
                    "\r\n" + //
                    "            <div class=\"col-12\">\r\n" + //
                    "\r\n" + //
                    "                <label class=\"form-label\">E-mail</label>\r\n" + //
                    "                <input type=\"text\" class=\"form-control\" name=\"eamil\">\r\n" + //
                    "            </div>\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "            <div class=\"col-12\">\r\n" + //
                    "                <label class=\"form-label\">Address</label>\r\n" + //
                    "                <input type=\"text\" class=\"form-control\" name=\"address\">\r\n" + //
                    "            </div>\r\n" + //
                    "            <div class=\"col-12\">\r\n" + //
                    "                <label for=\"email\" class=\"form-label\">Address 2</label>\r\n" + //
                    "                <input type=\"text\" class=\"form-control\" name=\"address2\">\r\n" + //
                    "            </div>\r\n" + //
                    "            <div class=\"row\">\r\n" + //
                    "                <div class=\"col-4\">\r\n" + //
                    "                    <div clas=\"form-label\">Country</div>\r\n" + //
                    "                    <select name=\"country\" id=\"\" class=\"forme-select form-control \">\r\n" + //
                    "                        <option value=\"korea\">Korea</option>\r\n" + //
                    "                        <option value=\"american\">American</option>\r\n" + //
                    "                        <option value=\"japan\">Japan</option>\r\n" + //
                    "                    </select>\r\n" + //
                    "                </div>\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "                <div class=\"col-4\">\r\n" + //
                    "                    <label class=\"form-label\">state</label>\r\n" + //
                    "                    <select name=\"state\" id=\"\" class=\"forme-select form-control \">\r\n" + //
                    "                        <option value=\"state1\">state1</option>\r\n" + //
                    "                        <option value=\"state2\">state2</option>\r\n" + //
                    "                        <option value=\"state3\">state3</option>\r\n" + //
                    "                    </select>\r\n" + //
                    "\r\n" + //
                    "                </div>\r\n" + //
                    "                <div class=\"col-4\">\r\n" + //
                    "                    <label for=\"zip_Name\" class=\"form-label\">Zip</label>\r\n" + //
                    "                    <input type=\"text\" class=\"form-control\" name=\"zip\">\r\n" + //
                    "                </div>\r\n" + //
                    "                <div>\r\n" + //
                    "\r\n" + //
                    "                    <button  type=\"submit\" class=\"btn btn-primary btn-sm\">go!!</button>\r\n" + //
                    "\r\n" + //
                    "                </div>\r\n" + //
                    "            </div>\r\n" + //
                    "\r\n" + //
                    "        </div>\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "    </form>\r\n" + //
                    "</body>\r\n" + //
                    "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n" + //
                    "\r\n" + //
                    "</html>";
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
