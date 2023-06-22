package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.commons.Commons;
import com.example.study_servlets.daos.CarInforsDao;
import com.example.study_servlets.daos.FactorysDao;

@WebServlet(urlPatterns = "/connectDBServlet")
public class ConnectDBServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            // Client에 html 화면 제공
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>bootstrap_tables</title>\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\">\r\n"
                    + //
                    "</head>\r\n" + //
                    "\r\n" + //
                    "<body>\r\n" + //
                    "    <div class=\"container\">\r\n" + //
                    "        <table class=\"table table-bordered table-hover\">\r\n" + //
                    "            <thead>\r\n" + //
                    "                <tr>\r\n" + //
                    "<thead>\r\n" + //
                    "<tr>\r\n" + //
                    "<th colspan = \"2\">COMPANY</th>\r\n" + //
                    "<th colspan = \"2\">COMPANY_ID</th>\r\n" + //
                    "</tr>\r\n" + //
                    "</thead>\r\n"; //

            // - query Edit

            FactorysDao factorysDao = new FactorysDao();
            ArrayList factorylist = new ArrayList<>();
            factorylist = factorysDao.seletAll();
            // select문에서 table 형태의 결과값 출력명령어
            for (int i = 0; i < factorylist.size(); i++) {
                HashMap hashMap = new HashMap<>();
                hashMap = (HashMap) factorylist.get(i);

                contents = contents + "<tr>\r\n" + //
                        "<td colspan = \"2\">" + hashMap.get("COMPANY_ID") + "</td>\r\n" + //
                        "<td colspan = \"2\">" + hashMap.get("COMPANY") + "</td>\r\n" + //
                        "</tr>\r\n"; //
            }
<<<<<<< HEAD

            contents = contents +
=======
//바로 아래 contents는 CarInforsDao에 대한 thead 넣은 구문. 
            contents = contents + 
>>>>>>> dc832d0df2ce1a76256f8e411d2ffc4086c531eb
                    "<tr>\r\n" + //
                    "<th>CAR_NAME</th>\r\n" + //
                    "<th>YEAR</th>\r\n" + //
                    "<th>CAR_INFOR_ID</th>\r\n" + //
                    "<th>COMPANY_ID</th>\r\n" + //
                    "</tr>\r\n";

            CarInforsDao carInforsDao = new CarInforsDao();
            ArrayList carInforsList = new ArrayList<>();
            carInforsList = carInforsDao.seletAll();
            for (int i = 0; i < carInforsList.size(); i++) {
                HashMap hashMap = new HashMap<>();
                hashMap = (HashMap) carInforsList.get(i);

                contents = contents + "<tr>\r\n" + //
                        "<td>" + hashMap.get("CAR_NAME") + "</td>\r\n" + //
                        "<td>" + hashMap.get("YEAR") + "</td>  \r\n" + //
                        "<td>" + hashMap.get("CAR_INFOR_ID") + "</td>  \r\n" + //
                        "<td>" + hashMap.get("COMPANY_ID") + "</td>  \r\n" + //
                        "</tr>\r\n"; //
            }

            contents = contents + "                </tr>\r\n" + //
                    "            </tbody>\r\n" + //
                    "        </table>\r\n" + //
                    "    </div>\r\n" + //
                    "</body>\r\n" + //
                    "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
                    + //
                    "\r\n" + //
                    "</html>";

            // 클라이언트에 html화면제공
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.println(contents);
            printWriter.close();

            // }
            // query = "select count(*) as CNT from factorys;";
            // resultSet = statement.executeQuery(query); // select문에서
            // // table 형태의 결과값 출력명령어
            // int totalCount = 0;
            // while (resultSet.next()) {
            // System.out.println(resultSet.getInt("CNT"));
            // totalCount = resultSet.getInt("CNT");
            // }

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

            System.out.println(e.getMessage());
        } finally {
            System.out.println();
        }
    }
}