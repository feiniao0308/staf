package com.bn.automation.staf.util;

import com.bn.automation.staf.core.STAFRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by fdkzv on 3/17/14.
 */
public class FileUtil {
    private static final Logger logger = LogManager.getLogger(FileUtil.class);

    public void createConfig(String path){
        logger.entry();
        try {
            SAXBuilder builder = new SAXBuilder();
            //File xmlFile = new File(getInfo().get(STAFConstant.CONFIG_KEY).toString());
            //InputStream is = getClass().getClassLoader().getResourceAsStream("config/Config.xml");
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
            logger.debug("congif inputstream: " + inputStream);
            //Reader reader = new InputStreamReader(inputStream);
            STAFRunner.setConfigDocument((Document) builder.build(inputStream));
            logger.debug("getConfigDocument() = " + STAFRunner.getConfigDocument());

            System.out.println("getConfigDocument() = " + STAFRunner.getConfigDocument());
            STAFRunner.getXmlMap().put(STAFRunner.getConfigXml(), STAFRunner.getConfigDocument());
            logger.debug(STAFRunner.getXmlMap());


        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }
    }

    public void createData(String path){
        try {
            System.out.println("path = " + path);
            SAXBuilder builder = new SAXBuilder();
            //File xmlFile = new File(getInfo().get(STAFConstant.CONFIG_KEY).toString());
            //InputStream is = getClass().getClassLoader().getResourceAsStream("config/Config.xml");
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
            System.out.println("inputStream = " + inputStream);
            //Reader reader = new InputStreamReader(inputStream);
            STAFRunner.setDataDocument((Document) builder.build(inputStream));


            System.out.println("getDataDocument() = " + STAFRunner.getDataDocument());
            STAFRunner.getXmlMap().put(STAFRunner.getDataXml(), STAFRunner.getDataDocument());


        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }
    }

    public void createEmptyXML(String path){
        try {
            //String path = System.getProperty("user.dir");
            //Element staflog = new Element("staflog");
            //Document doc = new Document(staflog);
            Document doc = new Document();

            XMLOutputter xmlOutput = new XMLOutputter();

            // display nice nice
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter("C:/Users/fdkzv/STAFLog/XML/STAFlog.xml"));

            System.out.println("File Saved!");
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }

    public void createUserDir(String dirName) throws IOException {
        File homeDir = new File(System.getProperty("user.home"));
        File dir = new File(homeDir, dirName);
        if (!dir.exists() && !dir.mkdirs()) {
            throw new IOException("Unable to create " + dir.getAbsolutePath());
        }
        System.out.println("dir.getAbsolutePath() = " + dir.getAbsolutePath());
    }

    public void createDir(String dirName) throws IOException {
        File userDir = new File(System.getProperty("user.dir"));
        File dir = new File(userDir, dirName);
        if (!dir.exists() && !dir.mkdirs()) {
            throw new IOException("Unable to create " + dir.getAbsolutePath());
        }
        System.out.println("dir.getAbsolutePath() = " + dir.getAbsolutePath());
    }
}
