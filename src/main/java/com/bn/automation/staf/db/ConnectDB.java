package com.bn.automation.staf.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by fdkzv on 3/26/14.
 */
public class ConnectDB {

    public static void main(String[] args){
        Connection connection = null;
        Statement statement = null;
        System.out.println("-------- Oracle JDBC Connection Testing ------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("driver fetched");
            System.out.println("Connecting to DB...");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@//tqabnidb01.hq.bn-corp.com:1521/EORDQ","bncomr","bncomr27");
            System.out.println("connection = " + connection);
            System.out.println("Creating statement...");
            statement = connection.createStatement();
            System.out.println("statement = " + statement);
            String sql;
            sql = "";

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
