package com.gis.medfind.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.gis.medfind.entity.Server;

public class utils {

    private static String urlHeader = "jdbc:postgresql://";

    public enum ConnectionMode{
        POST,
        GET
    }
    public static String connect(Server sv, String query,ConnectionMode cm, String objectName) {
        Connection conn = null;
        ResultSet info = null;        
        try {
            String url = urlHeader + sv.getHost()+":"+sv.getPort()+"/"+sv.getDatabaseName();
            System.out.println(url);
            conn = DriverManager.getConnection(url, sv.getUsername(), sv.getPassword());
            System.out.println("Connected to the PostgreSQL server successfully.");
            
            Statement queryStmnt = conn.createStatement();
            if(cm == ConnectionMode.GET){
                info = queryStmnt.executeQuery(query);
                return info.getString(objectName);
            }else{
                queryStmnt.execute(query);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Connection to PostgreSQL server Failed!!");
        }
        finally{
            try{
                conn.close();
            }catch(SQLException sql){}
        }
        return "";
    }
}
