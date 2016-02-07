package com.bn.automation.staf.helpers;

import com.bn.automation.staf.util.Json;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;


/**
 * Created by fdkzv on 3/31/14.
 */
public class Assert {

    private static final Logger logger = LogManager.getLogger();

    public void assertMap(Map<String,String> dataMap, Json responseJson){
        String responseBody = responseJson.toString();
        logger.trace(responseBody);

        for(Map.Entry<String,String> entry :dataMap.entrySet()){
            logger.trace("Data map key->" + entry.getKey());
            logger.trace("Data map value->" + entry.getValue());

            new Verify().assertEquals(responseJson.get(entry.getKey()),entry.getValue(), " | Assert: " + entry.getKey() + "->"+entry.getValue() );
        }


    }

    public void assertMap(Map<String,String> dataMap, ResultSet resultSet){


        try {
            if(resultSet.next()){
                for(Map.Entry<String,String> entry : dataMap.entrySet()){
                    logger.trace("Data map key->" + entry.getKey());
                    logger.trace("Data map value->" + entry.getValue());

                    try {

                            int columnType = resultSet.getMetaData().getColumnType(resultSet.findColumn(entry.getKey()));
                            System.out.println("columnType = " + columnType);
                            switch (columnType){
                                case Types.VARCHAR:
                                    System.out.println("VARCHAR");
                                    new Verify().assertEquals(resultSet.getString(entry.getKey()).toString(),entry.getValue()," | Assert: " + entry.getKey() + "->"+entry.getValue());
                                    break;
                                case 93:
                                    System.out.println("TIMESTAMP");
                                    //Date date = resultSet.getDate(entry.getKey());
                                    new Verify().assertEquals(resultSet.getDate(entry.getKey()).toString(),Date.valueOf(entry.getValue()).toString()," | Assert: " + entry.getKey() + "->"+entry.getValue());
                                    break;
                                case 91:
                                    System.out.println("DATE");
                                    //Date date = resultSet.getDate(entry.getKey());
                                    new Verify().assertEquals(resultSet.getDate(entry.getKey()).toString(),Date.valueOf(entry.getValue()).toString()," | Assert: " + entry.getKey() + "->"+entry.getValue());
                                    break;
                                default:
                                    System.out.println("DEFAULT");
                                    new Verify().assertEquals(resultSet.getString(entry.getKey()).toString(),entry.getValue()," | Assert: " + entry.getKey() + "->"+entry.getValue());


                            }
                            //new Verify().assertEquals(resultSet.getObject(entry.getKey()).toString(),entry.getValue()," | Assert: " + entry.getKey() + "->"+entry.getValue());





                        //new Verify().assertEquals(resultSet.getArray("").getObject(entry.getKey()).toString(),entry.getValue()," | Assert: " + entry.getKey() + "->"+entry.getValue());
                        //new Verify().assertEquals(resultSet.getObject(entry.getKey()).toString(),entry.getValue()," | Assert: " + entry.getKey() + "->"+entry.getValue());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*for(Map.Entry<String,String> entry : dataMap.entrySet()){
            logger.trace("Data map key->" + entry.getKey());
            logger.trace("Data map value->" + entry.getValue());

            try {
            if(resultSet.next()){

                int columnType = resultSet.getMetaData().getColumnType(resultSet.findColumn(entry.getKey()));
                System.out.println("columnType = " + columnType);
                new Verify().assertEquals(resultSet.getObject(entry.getKey()).toString(),entry.getValue()," | Assert: " + entry.getKey() + "->"+entry.getValue());


            }



                //new Verify().assertEquals(resultSet.getArray("").getObject(entry.getKey()).toString(),entry.getValue()," | Assert: " + entry.getKey() + "->"+entry.getValue());
                //new Verify().assertEquals(resultSet.getObject(entry.getKey()).toString(),entry.getValue()," | Assert: " + entry.getKey() + "->"+entry.getValue());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
    }
}
