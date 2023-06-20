package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yaml.snakeyaml.emitter.Emitable;

@WebServlet(urlPatterns = "/scheckoutResponseServlet")
public class sCheckoutResponseServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String firstname = request.getParameter("First_name");
            String lastname =request.getParameter("Last_name");
            String username =request.getParameter("Username");
            String email =request.getParameter("Email");
            String address = request.getParameter("Address");
            String address2 = request.getParameter("Address2");
            String country=request.getParameter("Country");
            String state = request.getParameter("State");
            String zip = request.getParameter("Zip");
            PrintWriter printWriter = response.getWriter();
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.css\">\r\n" + //
                    "    <title>Document</title>\r\n" + //
                    "</head>\r\n" + //
                    "<body>\r\n" + //
                    "    <div class=\"h1 text-center m-3 p-3\">Results</div>\r\n" + //
                    "    <div class=\"container\">\r\n" + //
                    "\r\n" + //
                    "        <br><div>Fisrt name :"+firstname+"</div><br>\r\n" + //
                    "        <div>Last name :"+lastname+"</div><br>\r\n" + //
                    "        <div> Username : "+username+"</div><br>\r\n" + //
                    "        <div>Email :"+email+"</div><br>\r\n" + //
                    "        <div>Address :"+address+"</div><br>\r\n" + //
                    "        <div>Address2 :"+address2+"</div><br>\r\n" + //
                    "        <div>Country :"+country+"</div><br>\r\n" + //
                    "        <div>State :"+state+"</div><br>\r\n" + //
                    "        <div>Zip :"+zip+"</div><br>\r\n" + //
                    "        \r\n" + //
                    "\r\n" + //
                    "    </div>\r\n" + //
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
