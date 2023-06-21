package com.example.study_servlets.controlls;

import java.sql.*;
import java.util.UUID;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = "/carInforsServlet")
public class CarInforsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection connection;
        try {

            String url = "jdbc:mysql://192.168.0.46:3306/db_cars";
            String user = "yojulab";
            String password = "!yojulab*";

            connection = DriverManager.getConnection(url, user, password); // network 자원사용
            System.out.println("DB연결 성공\n");
            // query

            UUID uuid = UUID.randomUUID();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM car_infors";
            ResultSet resultset = statement.executeQuery(query);

            while (resultset.next()){
            System.out.println(resultset.getString("CAR_NAME")+"/"+resultset.getInt("YEAR")
            +"/"+resultset.getString("CAR_INFOR_ID")+"/"+resultset.getString("COMPANY_ID"));
            }
            query = "INSERT INTO car_infors\n" + //
                    "(CAR_NAME,YEAR,CAR_INFOR_ID,COMPANY_ID)\n" + //
                    "VALUES\n" + //
                    "('KSAagain', 1234, 'K002','C002');";
            // while (resultset.next()) {
            //     System.out.println(resultset.getString("CAR_NAME") + "/" + resultset.getInt("YEAR")
            //             + "/" + resultset.getString("CAR_INFOR_ID") + "/" + resultset.getString("COMPANY_ID"));
            // }
            System.out.println("inserted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        }
    }

}
