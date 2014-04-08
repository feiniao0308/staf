package com.bn.automation.staf.db;

import com.bn.automation.staf.core.STAFRunner;
import com.bn.automation.staf.helpers.Assert;
import com.bn.automation.staf.util.FileUtil;
import com.bn.automation.staf.util.IDataContainer;
import com.bn.automation.staf.util.XML;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Map;

/**
 * Created by fdkzv on 4/1/14.
 */
public class OracleDriver implements DBDriver {

    private static final Logger logger = LogManager.getLogger(OracleDriver.class);
    private Connection connection;
    private String dbConnection;
    private String dbUser;
    private String dbPassword;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public void connect() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            setDbConnection("jdbc:oracle:thin:@qwecddb:1521:ECOMQ");
            setDbUser("QAREVID");
            setDbPassword("DiverQA");
            setConnection(DriverManager.getConnection(getDbConnection(), getDbUser(), getDbPassword()));
            logger.info("Connected with DB");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void doQuery(String sql) {
        try {

            setPreparedStatement(getConnection().prepareStatement(sql));
            setResultSet(getPreparedStatement().executeQuery());
            logger.info("Query->" + sql);
            /*setStatement(getConnection().createStatement());
            setResultSet(getStatement().executeQuery(sql));*/
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void autoAssert(IDataContainer containerName) {
        Map<String,String> dataMap = containerName.get();
        new Assert().assertMap(dataMap,getResultSet());

    }

    @Override
    public void viewQueryResult(String sql) {
        doQuery(sql);
        try {
            while(getResultSet().next()){
            for (int col = 1; col<getResultSet().getMetaData().getColumnCount();col++){
                System.out.println("getResultSet().getObject(col).toString() = " + getResultSet().getObject(col).toString());
            }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void setData(String dataPath) {
        new FileUtil().createData(dataPath);
        logger.info("Data XML is set->" + dataPath);
    }

    @Override
    public XML getData() {
        return STAFRunner.getDataXml();
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public void setPreparedStatement(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    public String getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(String dbConnection) {
        this.dbConnection = dbConnection;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }


    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
}
