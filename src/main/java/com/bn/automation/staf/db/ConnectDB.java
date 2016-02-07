package com.bn.automation.staf.db;

import java.sql.*;
import java.util.ArrayList;

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
            //connection = DriverManager.getConnection("jdbc:oracle:thin:@tqabnidb01.hq.bn-corp.com:1521:EORDQ","bncomr","bncomr27");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@qwecddb:1521:ECOMQ","QAREVID","DiverQA");
            System.out.println("connection = " + connection);
            System.out.println("Creating statement...");
            String sql;
            sql = "SELECT * FROM BN_CORE.DPS_USER";
            statement = connection.createStatement();
            DatabaseMetaData meta = connection.getMetaData();
            System.out.println("meta = " + meta);
            ArrayList<String> allFields = new ArrayList<String>();
            ResultSet columnsResultSet = meta.getColumns(null, null, "BN_CORE.DPS_USER", null);
            while (columnsResultSet.next()) { allFields.add(columnsResultSet.getString("COLUMN_NAME")); }

            System.out.println("statement = " + statement);




            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData metaData = rs.getMetaData();


            //int i = 0;
            for(int col = 1; col < metaData.getColumnCount() ; col++){
                System.out.println("col = " + col);
                System.out.println("column type  = " +  metaData.getColumnType(col));
                System.out.println("column name  = " +  metaData.getColumnName(col));
            }

            /*while (rs.next()) {
                //System.out.println("rs = " + rs.getObject("password"));
                System.out.println("i = " + i);
                String userid = rs.getString(3);
                RowId id = rs.getRowId(1);
                String username = rs.getString("FIRST_NAME");
                //Object one = rs.getObject("BN_CORE.BN_USER.FIRST_NAME");

                System.out.println("userid : " + userid);
                System.out.println("username : " + username);
                i++;
                //System.out.println("one = " + one);
                //System.out.println("one.toString() = " + one.toString());

            }*/

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
