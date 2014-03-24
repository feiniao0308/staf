package com.bn.automation.scripts;

import com.bn.automation.staf.util.FileUtil;
import org.apache.logging.log4j.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by fdkzv on 3/17/14.
 */
public class Log1 {
    //static System.setProperty("xml_log_file","target/test1");
    //private static final Logger logger = LogManager.getLogger(Log1.class);
    private static Logger logger;

   /* static {
        System.setProperty("xmllog","test");
        final Logger logger = LogManager.getLogger(Log1.class);
        try {
            new FileUtil().createUserDir("STAFLog/XML");
            new FileUtil().createEmptyXML("h");

            logger.info("hello world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args){
        String time = new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss.S").format(Calendar.getInstance().getTime());
        time = "target/STAFLog_"+time;
       // String home = System.getProperty("user.name")

        System.setProperty("xmllog",time);
        logger = LogManager.getLogger();

        final Marker SQL_MARKER = MarkerManager.getMarker("SQL");
        logger.debug(SQL_MARKER,"this is new marker");


        System.out.println("time = " + time);
        //SimpleLayout
        try {
            new FileUtil().createUserDir("STAFLog/XML");
            new FileUtil().createEmptyXML("h");

           logger.info("hello world");
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*System.out.println("System.getProperty(\"user.home\") = " + System.getProperty("user.home"));
        String home = System.getProperty("user.home");
        System.out.println("home = " + home);
        File theDir = new File("Log");

        // if the directory does not exist, create it
        if (!theDir.exists()) {
            System.out.println("creating directory: " + theDir);
            boolean result = theDir.mkdir();

            if(result) {
                System.out.println("DIR created");
            }
        }

        System.setProperty("xml_log_file",home+"/Log/test.xml");
        new FileUtil().createEmptyXML("h");*//*
    }*/


}
}