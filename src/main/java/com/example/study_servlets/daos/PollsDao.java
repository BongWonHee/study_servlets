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
}
