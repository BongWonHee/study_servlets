package com.example.study_servlets.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.study_servlets.commons.Commons;

public class CarInforsDao {
    // select 문 class화
    // DB에서 오는 레코드의 column과 value를 HashMap의 key와 value로 가져와
    // ArrayList에 넣는다.
    public ArrayList carInfor() {
        ArrayList collector = new ArrayList();
        try {
            // 1.statement DB연결.... 이건 commons 클래스 이용
            Commons dbconnect = new Commons();
            Statement statement = dbconnect.getStatement();
            statement = dbconnect.getStatement();
            String query = "SELECT *\n" + //
                    "FROM car_infors;";
            // select로 car_infors 부름
            ResultSet resultSet = statement.executeQuery(query);
            HashMap hashmap = new HashMap();
            while (resultSet.next()) {
                hashmap = new HashMap();
                hashmap.put("CAR_NAME", resultSet.getString("CAR_NAME"));
                hashmap.put("YEAR", resultSet.getString("YEAR"));
                hashmap.put("CAR_INFOR_ID",  resultSet.getString("CAR_INFOR_ID"));
                hashmap.put("COMPANY_ID", resultSet.getString("COMPANY_ID"));
                // key 설정한 HashMap을 arraylist에 담는다.
                collector.add(hashmap);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return collector;

    }
}
