package com.example.study_servlets.commons;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class Commons {

    public Statement getStatement() {
        
        String url = "jdbc:mysql://127.0.0.1:3306/db_survey";
        String user = "root";
        String password = "!yojulab*";
        
        Statement statement = null;
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public String getGeneratorID() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyyhh:mm:ss");
        String strDate = formatter.format(date);
        return strDate;
    }

    public String generatUuid() {

        return UUID.randomUUID().toString();
    }
}
