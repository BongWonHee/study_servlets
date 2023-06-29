package com.example.study_servlets.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.study_servlets.commons.Commons;

public class PollsDao {
    public ArrayList SeletWhithSearch(String search) {

        ArrayList InforList = new ArrayList();
        try {

            Commons commons = new Commons();
            Statement statement = commons.getStatement(); // Editor in Workbanch
            String query = "SELECT T_QC.QUESTIONS_ID,T_QC.CHOICE_ID,T_Q.QUESTIONS,T_C.CHOICE\n" + //
                    "FROM question_choice as T_QC\n" + //
                    "\tinner join questions as T_Q\n" + //
                    "\ton T_QC.QUESTIONS_ID = T_Q.QUESTIONS_ID \n" + //
                    "    inner join choice as T_C\n" + //
                    "    on T_QC.CHOICE_ID = T_C.CHOICE_ID \n" + //
                    "    order by T_QC.QUESTIONS_ID asc;";

            ResultSet resultset = statement.executeQuery(query);

            HashMap InforRecord = new HashMap<>();
            while (resultset.next()) {
                InforRecord = new HashMap<>();
                InforRecord.put("QUESTIONS_ID", resultset.getString("QUESTIONS_ID"));
                InforRecord.put("CHOICE_ID", resultset.getString("CHOICE_ID"));
                InforRecord.put("QUESTIONS", resultset.getString("QUESTIONS"));
                InforRecord.put("CHOICE", resultset.getString("CHOICE"));

                InforList.add(InforRecord);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return InforList;
    }

    public int Insert(HashMap<String, Object> map) {
        int count = 0;
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement();
            String query = "insert into statistics\n" + //
                    "(STATISTICS_ID,RESPONDENTS_ID,QUESTIONS_ID,CHOICE_ID )\n" + //
                    "value\n";
            int loops = 1;
            String userid = "R1"; // from session
            for (String key : map.keySet()) { // 해쉬맵의 키뭉치를 받아서 풀어주는것
                String uuid = commons.generatUuid();

                if (loops > 1) {// for문이 작동하는 동안 첫번째를 재외한 나머지는 콤마를 넣어주자.
                    query = query + ", ";
                }
                query = query + "('" + uuid + "','" + userid + "','" + key + "','" + map.get(key) + "')\n"; //
                // System.out.println(key + ", " + map.get(key));
                loops = loops + 1;
            }
            query = query + ";";
            count = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
// 상아_polls selectWithSerach
    // public ArrayList SelectWithSearch(String search) {
    //     ArrayList InforList = new ArrayList<>();
    //     try {
    //         Commons commons = new Commons();
    //         Statement statement = commons.getStatement(); // Editor in Workbanch
    //         String query = "SELECT t_QC.QUESTIONS_ID, t_QC.CHOICE_ID, t_Q.QUESTIONS, t_C.CHOICE\r\n" + //
    //                 "FROM question_choice AS t_QC\r\n" + //
    //                 "INNER JOIN questions AS t_Q\r\n" + //
    //                 "ON t_QC.QUESTIONS_ID = t_Q.QUESTIONS_ID \r\n" + //
    //                 "INNER JOIN choice AS t_C\r\n" + //
    //                 "ON t_QC.CHOICE_ID=t_C.CHOICE_ID \r\n" + //
    //                 "ORDER BY t_QC.QUESTIONS_ID, t_QC.CHOICE_ID";
    //         ResultSet resultSet = statement.executeQuery(query);

    //         HashMap InforRecord = new HashMap<>();
    //         while (resultSet.next()) {
    //             InforRecord = new HashMap<>();
    //             InforRecord.put("t_QC.QUESTIONS_ID", resultSet.getString("t_QC.QUESTIONS_ID"));
    //             InforRecord.put("t_QC.CHOICE_ID", resultSet.getString("t_QC.CHOICE_ID"));
    //             InforRecord.put("t_Q.QUESTIONS", resultSet.getString("t_Q.QUESTIONS"));
    //             InforRecord.put("t_C.CHOICE", resultSet.getString("t_C.CHOICE"));

    //             InforList.add(InforRecord);
    //         }
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //     }
    //     return InforList;
    // }

}
