package com.bn.automation.scripts;

import com.bn.automation.staf.core.STAFLogger;
import com.bn.automation.staf.helpers.STAFConstant;
import com.bn.automation.staf.util.HTMLGenerator;
import org.apache.logging.log4j.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by fdkzv on 3/20/14.
 */
public class Log2 {
    private static Logger logger ;

    public static void main(String[] args){


        String path = System.getProperty("user.dir");
        System.setProperty("xml_log","testlog");
        logger = LogManager.getLogger();
        logger.info("hello");
        logger.debug("world");
        new STAFLogger().closeStafLog(path+"\\testlog.xml");
        new HTMLGenerator().convertXML();

        File htmlFile = new File(path+"/reports/Staflognew.html");
        try {
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
