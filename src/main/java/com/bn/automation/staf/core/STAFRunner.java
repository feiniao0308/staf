package com.bn.automation.staf.core;

import com.bn.automation.staf.anno.STAFScript;
import com.bn.automation.staf.anno.STAFSuite;
import com.bn.automation.staf.helpers.STAFConstant;
import com.bn.automation.staf.util.STAFConfig;
import com.bn.automation.staf.util.XML;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class STAFRunner extends IScript {

    private static final Logger logger = LogManager.getLogger(STAFRunner.class);
    private static final ScriptRunner SCRIPT_RUNNER = new ScriptRunner();
    private static final SuiteRunner SUITE_RUNNER = new SuiteRunner();
    private static final XML CONFIG_XML = new XML();
    private static final XML DATA_XML = new XML();
    private static Set<Class<?>> STAFScriptSet = new HashSet<Class<?>>();
    private static Set<Class<?>> STAFSuiteSet = new HashSet<Class<?>>();
    private static Document configDocument;
    private static Document dataDocument;
    private static Map<XML, Document> xmlMap = new HashMap<XML, Document>();
    private static int testID;


    public static void main(String[] runnerArgs) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        validateScriptName(runnerArgs);
        validateConfigEnv();
        if (isGridMode()) {
            System.out.println("******************GRID MODE*****************");
        } else {
            System.out.println("******************LOCAL MODE*****************");


        }

        if (!STAFScriptSet.isEmpty()) {
            System.out.println("****************SCRIPT EXECUTION*****************");
            for (Class<?> stafScript : STAFScriptSet) {
                SCRIPT_RUNNER.initiateScript(stafScript);
            }


        }

        if (!STAFSuiteSet.isEmpty()) {
            System.out.println("****************SUITE EXECUTION*****************");
            for (Class<?> stafSuite : STAFSuiteSet) {
                SCRIPT_RUNNER.initiateScript(stafSuite);
            }
        }


    }

    private static void validateScriptName(String[] scripts) {
        if (scripts.length == 0) {
            logger.info("Pass script/suite to STAFRunner to execute");
            logger.error("Script execution process will be killed");
            System.exit(0);
        } else {
            logger.debug("Setting the environment for staf script/suite execution");
            setEnv();
            createClassMap(scripts);
        }
    }

    private static void createClassMap(String[] scripts) {
        for (String script : scripts) {

            try {
                Class<?> clazz = Class.forName(script);
                if (isStafScript(clazz)) {
                    System.out.println("**************STAF_SCRIPT*****************");
                    STAFScriptSet.add(clazz);
                } else if (isStafSuite(clazz)) {
                    System.out.println("**************STAF_SUITE******************");
                    STAFSuiteSet.add(clazz);
                } else {
                    logger.error("Unable to identify as STAFScript or STAFSuite - Please provide appropriate annotations for execution");
                }
            } catch (ClassNotFoundException e) {
                logger.error("Class not found for : " + script);
                e.printStackTrace();
            }
        }
    }

    private static void validateConfigEnv() {
        if (!getInfo().containsKey(STAFConstant.CONFIG_KEY)) {
            logger.info("Config file needs to be passed for staf script/suite execution");
            logger.error("Script execution process will be killed");
            System.exit(0);
        } else {
            logger.debug("Config file location is set as : " + getInfo().get(STAFConstant.CONFIG_KEY));
            createConfigMap();
            setConfigEnv();
        }
    }

    private static void createConfigMap() {
        logger.entry();

        try {
            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(getInfo().get(STAFConstant.CONFIG_KEY).toString());
            System.out.println("xmlFile = " + xmlFile);
            setConfigDocument((Document) builder.build(xmlFile));
            System.out.println("getConfigDocument() = " + getConfigDocument());
            getXmlMap().put(CONFIG_XML, getConfigDocument());

        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }
    }

    private static void setConfigEnv() {
        try {

            //STAFConfig stafConfig = data STAFConfig();
            if (getConfigXml().isFieldPresent(STAFConstant.DEFAULT_BROWSER_NAME))
                //putInfoMap(STAFConstant.BROWSER_NAME_KEY, stafConfig.getField(STAFConstant.DEFAULT_BROWSER_NAME));
                putInfoMap(STAFConstant.BROWSER_NAME_KEY, getConfigXml().getField(STAFConstant.DEFAULT_BROWSER_NAME));
            if (getConfigXml().isFieldPresent(STAFConstant.DEFAULT_URL))
                putInfoMap(STAFConstant.URL_KEY, getConfigXml().getField(STAFConstant.DEFAULT_URL));
            if (getConfigXml().isFieldPresent(STAFConstant.IE_DRIVER_PATH))
                putInfoMap(STAFConstant.IE_DRIVER_PATH_KEY, getConfigXml().getField(STAFConstant.IE_DRIVER_PATH));
            if (getConfigXml().isFieldPresent(STAFConstant.CHROME_DRIVER_PATH))
                putInfoMap(STAFConstant.CHROME_DRIVER_PATH_KEY, getConfigXml().getField(STAFConstant.CHROME_DRIVER_PATH));
            if (getConfigXml().isFieldPresent(STAFConstant.KILL_BROWSER_AFTER_TEST))
                putInfoMap(STAFConstant.KILL_BROWSER_AFTER_TEST_KEY, getConfigXml().getField(STAFConstant.KILL_BROWSER_AFTER_TEST));
            if (getConfigXml().isFieldPresent(STAFConstant.KILL_DRIVER_AFTER_TEST))
                putInfoMap(STAFConstant.KILL_DRIVER_AFTER_TEST_KEY, getConfigXml().getField(STAFConstant.KILL_DRIVER_AFTER_TEST));
            if (getConfigXml().isFieldPresent(STAFConstant.GRID))
                putInfoMap(STAFConstant.GRID_KEY, getConfigXml().getField(STAFConstant.GRID));


        } catch (Throwable e) {
            e.printStackTrace();
        }

    }


    //is Methods
    private static boolean isStafScript(Class<?> clazz) {
        if (clazz.getAnnotation(STAFScript.class) != null) {
            logger.debug(clazz.getCanonicalName() + " is identified as STAFScript");
            return true;
        } else {
            logger.trace(clazz.getCanonicalName() + "is identified as non-STAFScript");
            return false;
        }


    }

    private static boolean isStafSuite(Class<?> clazz) {
        if (clazz.getAnnotation(STAFSuite.class) != null) {
            logger.debug(clazz.getCanonicalName() + " is identified as STAFSuite");
            return true;
        } else {
            logger.trace(clazz.getCanonicalName() + "is identified as non-STAFSuite");
            return false;
        }
    }

    public static boolean isGridMode() {
        if ((boolean) getInfo().get(STAFConstant.GRID_KEY)) {
            logger.info("grid execution is set to true");
            logger.info("STAF GRID EXECUTION STARTS NOW");
            viewInfoMap();
            return true;

        } else {
            logger.info("local execution is set to true");
            logger.info("STAF LOCAL EXECUTION STARTS NOW");
            viewInfoMap();
            return false;
        }

    }

    //Setters and Getters
    public static Document getDataDocument() {
        return dataDocument;
    }

    public static void setDataDocument(Document dataDocument) {
        STAFRunner.dataDocument = dataDocument;
    }

    public static Document getConfigDocument() {
        return configDocument;
    }

    public static void setConfigDocument(Document configDocument) {
        STAFRunner.configDocument = configDocument;
    }

    public static XML getDataXml() {
        return DATA_XML;
    }

    public static XML getConfigXml() {
        return CONFIG_XML;
    }

    public static int getTestID() {
        return testID;
    }

    public static void setTestID(int currentID) {
        STAFRunner.testID = currentID;
    }

    public static Map<XML, Document> getXmlMap() {
        return xmlMap;
    }

    public static void setXmlMap(Map<XML, Document> xmlMap) {
        STAFRunner.xmlMap = xmlMap;
    }


}
