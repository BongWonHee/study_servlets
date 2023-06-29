package com.example.study_servlets.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.study_servlets.commons.Commons;

public class PollsDao {

    public int Insert(HashMap<String, Object> map) {
        int count = 0;
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement(); // Editor in Workbanch
            String query = "INSERT INTO statistics (STATISTICS_ID,RESPONDENTS_ID,QUESTIONS_ID,CHOICE_ID)\n" + //
                    "VALUES \n";

            // print map
            int loops = 1;
            
            String userId = "R1"; // 원래는 from session
            // loops를 이용해서 첫번째 돌때는 ,가 없고
            // 그 이후 돌때는 , 를 붙일 수 있게.
            for (String key : map.keySet()) {
                String uuid = commons.generatUuid();
                if (loops > 1) {
                    query = query + ",";
                }
                query = query + "('" + uuid + "','" + userId + "','" + key + "','" + map.get(key) + "')\n";
                // key를 전체 가져오고 .. hashmap의key, map.get(key)를 가져온다
                // System.out.println(key + "," + map.get(key));
                loops = loops + 1;
            }
            query = query + ";";
            count = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public ArrayList SelectWithSearch(String search) {
        ArrayList InforList = new ArrayList<>();
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement(); // Editor in Workbanch
            String query = "SELECT t_QC.QUESTIONS_ID, t_QC.CHOICE_ID, t_Q.QUESTIONS, t_C.CHOICE\r\n" + //
                    "FROM question_choice AS t_QC\r\n" + //
                    "INNER JOIN questions AS t_Q\r\n" + //
                    "ON t_QC.QUESTIONS_ID = t_Q.QUESTIONS_ID \r\n" + //
                    "INNER JOIN choice AS t_C\r\n" + //
                    "ON t_QC.CHOICE_ID=t_C.CHOICE_ID \r\n" + //
                    "ORDER BY t_QC.QUESTIONS_ID, t_QC.CHOICE_ID";
            ResultSet resultSet = statement.executeQuery(query);

            HashMap InforRecord = new HashMap<>();
            while (resultSet.next()) {
                InforRecord = new HashMap<>();
                InforRecord.put("t_QC.QUESTIONS_ID", resultSet.getString("t_QC.QUESTIONS_ID"));
                InforRecord.put("t_QC.CHOICE_ID", resultSet.getString("t_QC.CHOICE_ID"));
                InforRecord.put("t_Q.QUESTIONS", resultSet.getString("t_Q.QUESTIONS"));
                InforRecord.put("t_C.CHOICE", resultSet.getString("t_C.CHOICE"));

                InforList.add(InforRecord);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return InforList;
    }

}
