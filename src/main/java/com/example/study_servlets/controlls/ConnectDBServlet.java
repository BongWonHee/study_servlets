package com.example.study_servlets.controlls;

import java.io.IOException;

import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/connectDBServlet")
public class ConnectDBServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // - MySQL workbench 실행 : JDBC
            // - User/password와 접속 IP:port 접속
            String url = "jdbc:mysql://192.168.224:3306/db_cars";
            String user = "root";
            String password = "!yojulab*";

            Connection connection = DriverManager.getConnection(url, user, password); // network 자원사용
            System.out.println("DB연결 성공\n");

            Statement statement = connection.createStatement();
            String query = "";

            // - query Edit
            statement = connection.createStatement(); // DB자원
            query = "SELECT * FROM factorys";
            ResultSet resultSet = statement.executeQuery(query);
            // // FactoryDMLs factoryDMLs = new FactoryDMLs();
            // ResultSet resultSet = factoryDMLs.selectStatements(statement, query); //
            // select문에서 table 형태의 결과값 출력명령어
            while (resultSet.next()) {
                System.out.println(resultSet.getString("COMPANY_ID") +
                        resultSet.getString("COMPANY"));
            }
            // query = "select count(*) as CNT from factorys;";
            // resultSet = factoryDMLs.selectStatements(statement, query); // select문에서
            // table 형태의 결과값 출력명령어
            // int totalCount = 0;
            // while (resultSet.next()) {
            // System.out.println(resultSet.getInt("CNT"));
            // totalCount = resultSet.getInt("CNT"); }

            // insert into factorys
            // (COMPANY_ID, COMPANY)
            // value
            // ('CAR-01', 'AUDI');

            // String companyid = "CAR-01";
            // String company = "AUDI";
            // String newcompany = "페라리";
            // int count = 0;

            // query = "insert into factorys " + "(COMPANY_ID, COMPANY) " + "value " + "('"
            // + companyid + "', '" + company
            // + "') ";
            // count = factoryDMLs.InsertStatements(statement, query); // executeUpdate 는
            // insert, update, delete 를 사용할때 씀

            // query = " UPDATE factorys " + "SET COMPANY = '" + newcompany + "' " + "WHERE
            // COMPANY_ID = '" + companyid
            // + "' ";
            // count = factoryDMLs.updatestatements(statement, query); // CAR-01 의 AUDI를
            // 페라리로 변경

            // query = "delete FROM factorys " + "WHERE COMPANY_ID = '" + companyid + "'";
            // count = factoryDMLs.deletestatements(statement, query); // CAR-01 삭제

            // statement.close(); // 자원 반납 하기.
            // connection.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        } finally {
            System.out.println();
        }
    }
}