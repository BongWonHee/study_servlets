package com.example.study_servlets.controlls;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.commons.Commons;
@WebServlet (urlPatterns = "/carInforsServlet")
public class CarInforsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // - MySQL workbench 실행 : JDBC
            // - User/password와 접속 IP:port 접속
            Commons commons = new Commons();
            String uuid = commons.generatUuid();
            // String url = "jdbc:mysql://127.0.0.1:3306/db_cars";
            // String user = "root";
            // String password = "!yojulab*";
            String url = "jdbc:mysql://192.168.0.46:3306/db_cars";
            String user = "yojulab";
            String password = "!yojulab*";

            Connection connection = DriverManager.getConnection(url, user, password); // network 자원사용
            System.out.println("DB연결 성공\n");

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM db_cars.car_infors";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("CAR_NAME") + "/" + resultSet.getInt("YEAR")
                        + "/" + resultSet.getString("CAR_INFOR_ID") + "/" + resultSet.getString("COMPANY_ID"));
            }
            ;
            query = "INSERT INTO car_infors\n" + //
                    "(CAR_NAME,YEAR,CAR_INFOR_ID,COMPANY_ID)\n" + //
                    "VALUES\n" + //
                    "('KSAagain', 1234, '" + uuid + "','C002');";
            int result = statement.executeUpdate(query);
            // while (resultset.next()) {
            // System.out.println(resultset.getString("CAR_NAME") + "/" +
            // resultset.getInt("YEAR")
            // + "/" + resultset.getString("CAR_INFOR_ID") + "/" +
            // resultset.getString("COMPANY_ID"));
            // }
            // String carname = "supercar";
            // String year = "2022";
            // String companyID = "C001";
            // query = "insert into car_infors\n" + //
            // "(CAR_NAME,YEAR,CAR_INFOR_ID,COMPANY_ID)\n" + //
            // "value\n" + //
            // "('"+carname+"','"+year+"','" + uuid + "','"+companyID+"')";
            // int result = statement.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
