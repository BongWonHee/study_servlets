package com.example.study_servlets.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.study_servlets.commons.Commons;

public class FactorysDao {
    public ArrayList seletAll() {
        ArrayList arrayList = new ArrayList();
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement();
            String query = "SELECT * FROM factorys";
            ResultSet resultSet = statement.executeQuery(query); //
            HashMap hashMap = new HashMap<>(); // HashMap을 hashMap으로 선언한다!
            while (resultSet.next()) {
                hashMap = new HashMap<>(); // 선언된 hashMap을 본다. 초기화 시켜서 담는다!
                hashMap.put("COMPANY_ID", resultSet.getString("COMPANY_ID"));
                hashMap.put("COMPANY", resultSet.getString("COMPANY"));
                arrayList.add(hashMap);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return arrayList;

    }
}
