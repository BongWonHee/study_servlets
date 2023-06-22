package com.example.study_servlets.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.study_servlets.commons.Commons;

public class OptioninforsDao {
    // Delete문 Method화 하기
    public int DeleteWithUniqueID(String unique_id) {
        int count = 0;
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement();// Editor in Workbench
            String query = "DELETE FROM option_infors\n" + //
                    "WHERE OPTION_INFOR_ID ='" + unique_id + "'";
            count = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    // while문을 Method로 돌리기_INSERT, SELECT, UPDATE, DELETE
    public ArrayList SelectWithSearch(String search) {
        ArrayList optionInforList = new ArrayList<>();

        try {
            // null은 뭔지 모름. 무한대의 null임. 고로 if 조건으로 search에 빈값임을 알려줌
            if (search == null) {

                search = "";
            }
            Commons commons = new Commons();
            Statement statement = commons.getStatement();// statement에 query던지기
            String query = "SELECT *\n" + //
                    "FROM option_infors\n" + //
                    "WHERE OPTION_NAME LIKE'" + search + "%'";
            ResultSet resultSet = statement.executeQuery(query);
            // Resultset으로 query던진 결과 받기?
            HashMap optionInforRecord = new HashMap<>();
            // while (resultSet.next())는 하나씩 불러온다는 뜻. record형식으로 = row 형식으로
            while (resultSet.next()) {
                optionInforRecord = new HashMap<>();
                optionInforRecord.put("OPTION_INFOR_ID", resultSet.getString("OPTION_INFOR_ID"));
                optionInforRecord.put("OPTION_NAME", resultSet.getString("OPTION_NAME"));

                optionInforList.add(optionInforRecord);// hashmap을 arraylist에 담는다

            }
            // resultset으로 담아진 결과를 getString으로 받기
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return optionInforList;
    }

}
