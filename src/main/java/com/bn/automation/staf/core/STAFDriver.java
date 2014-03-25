package com.bn.automation.staf.core;

import com.bn.automation.staf.helpers.STAFConstant;
import com.bn.automation.staf.helpers.Verify;
import com.bn.automation.staf.util.FileUtil;
import com.bn.automation.staf.util.IDataContainer;
import com.bn.automation.staf.util.XML;
import com.bn.automation.staf.util.XMLReader;
import com.bn.automation.staf.widget.Label;
import com.bn.automation.staf.widget.TextBox;
import com.bn.automation.staf.widget.Widgets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class STAFDriver extends Driver {

    private static final Logger logger = LogManager.getLogger(STAFDriver.class);
    @Deprecated
    public static WebDriver iDriver;
    private static WebDriver wd;
    private static String browser;
    @Deprecated
    private volatile static STAFDriver stafDriver = null;
    private static Map<String, Object> infoMap = IScript.getInfo();

    public STAFDriver() {
        logger.entry();
        logger.info("STAFDriver class is intialized and STAFDriver instance will be created ");
        setCongif(infoMap.get(STAFConstant.CONFIG_KEY).toString());
        if (!STAFRunner.isGridMode()) {

            logger.info("------------------------------------------------------------------------");
            logger.info("MODE : LOCAL");
            logger.info("------------------------------------------------------------------------");
            switch (getInfoMap().get(STAFConstant.BROWSER_NAME_KEY).toString()
                    .toLowerCase()) {
                case STAFConstant.FIREFOX:
                    logger.info(STAFConstant.DASH);
                    logger.info("BROWSER : FIREFOX");
                    logger.info(STAFConstant.DASH);
                    setWd(new FirefoxDriver());
                    STAFManager.getInstance(this, getWd());
                    logger.info("Firefox browser is set and opened in data window");
                    break;
                case STAFConstant.CHROME:
                    logger.info(STAFConstant.DASH);
                    logger.info("BROWSER : CHROME");
                    logger.info(STAFConstant.DASH);
                    // TODO check whether driver exist in that location
                    System.setProperty(STAFConstant.WEBDRIVER_CHROME_DRIVER,
                            getInfoMap().get(STAFConstant.CHROME_DRIVER_PATH_KEY)
                                    .toString());
                    setWd(new ChromeDriver());
                    STAFManager.getInstance(this, getWd());
                    logger.info("Chrome browser is set and opened in data window");
                    break;
                case STAFConstant.IE:
                    logger.info(STAFConstant.DASH);
                    logger.info("BROWSER : INTERNET EXPLORER");
                    logger.info(STAFConstant.DASH);
                    DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                    capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                    // TODO check whether driver exist in that location
                    System.setProperty(STAFConstant.WEBDRIVER_IE_DRIVER,
                            getInfoMap().get(STAFConstant.IE_DRIVER_PATH_KEY)
                                    .toString());
                    setWd(new InternetExplorerDriver(capabilities));
                    STAFManager.getInstance(this, getWd());
                    logger.info("Internet Explorer browser is set and opened in data window");
                    break;
                case STAFConstant.HTML_UNIT:
                    logger.info(STAFConstant.DASH);
                    logger.info("BROWSER : HTML UNIT");
                    logger.info(STAFConstant.DASH);
                    setWd(new HtmlUnitDriver());
                    STAFManager.getInstance(this, getWd());
                    logger.info("HTML unit browser is set and opened in data window");
                    break;
                case STAFConstant.SAFARI:
                    logger.info(STAFConstant.DASH);
                    logger.info("BROWSER : SAFARI");
                    logger.info(STAFConstant.DASH);
                    setWd(new SafariDriver());
                    STAFManager.getInstance(this, getWd());
                default:
                    logger.info(STAFConstant.DASH);
                    logger.error("ERROR : INVALID BROWSER");
                    logger.info(STAFConstant.DASH);
                    throw new IllegalArgumentException("Invalid browser type : "
                            + browser);
            }
        } else if (STAFRunner.isGridMode()) {

            if (infoMap.get(STAFConstant.BROWSER_NAME_KEY).toString().toLowerCase().equals(STAFConstant.FIREFOX.toLowerCase())) {
                DesiredCapabilities capability = DesiredCapabilities.firefox();
                try {
                    setWd(new RemoteWebDriver(new URL(infoMap.get(STAFConstant.HUB_URL_KEY).toString() + "/wd/hub"), capability));
                    STAFManager.getInstance(this, getWd());
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        } else {
            logger.info(STAFConstant.DASH);
            logger.error("INVALID EXECUTION MODE");
            logger.info(STAFConstant.DASH);
        }

    }

    // Depreacted methods
    // TODO remove these methods
    @Deprecated
    public STAFDriver(String browser) {

        System.out.println(this);

        switch (browser) {
            case STAFConstant.FIREFOX:
                setBrowser(STAFConstant.FIREFOX);
                iDriver = new FirefoxDriver();
                STAFManager.getInstance(this, iDriver);
                logger.info("Firefox browser is set and opened in data window");
                break;
            case STAFConstant.CHROME:
                setBrowser(STAFConstant.CHROME);
                iDriver = new ChromeDriver();
                logger.info("Chrome browser is set and opened in data window");
                break;
            case STAFConstant.IE:
                setBrowser(STAFConstant.IE);
                iDriver = new InternetExplorerDriver();
                logger.info("Internet Explorer browser is set and opened in data window");
                break;
            case STAFConstant.HTML_UNIT:
                setBrowser(STAFConstant.HTML_UNIT);
                iDriver = new HtmlUnitDriver();
                logger.info("HTML unit browser is set and opened in data window");
                break;
            case "other1":
            case "other2":
            default:
                throw new IllegalArgumentException("Invalid browser type : "
                        + browser);
        }

    }

    @Deprecated
    public STAFDriver(String browser, String dataFileLocation) {
        setDataFileLocation(dataFileLocation);
        switch (browser) {
            case STAFConstant.FIREFOX:
                iDriver = new FirefoxDriver();
                break;
            case STAFConstant.CHROME:
                iDriver = new ChromeDriver();
                break;
            case STAFConstant.IE:
                iDriver = new InternetExplorerDriver();
                break;
            case STAFConstant.HTML_UNIT:
                iDriver = new HtmlUnitDriver();
                break;
            case "other1":
            case "other2":
            default:
                throw new IllegalArgumentException("Invalid browser type : "
                        + browser);
        }
    }





    public static Map<String, Object> getInfoMap() {
        return infoMap;
    }

    private static WebDriver getWd() {
        return wd;
    }

    private static void setWd(WebDriver wd) {
        STAFDriver.wd = wd;
    }

    @Deprecated
    public static WebDriver getiDriver() {
        return iDriver;
    }

    public static String getBrowser() {
        return logger.exit(browser);
    }

    public static void setBrowser(String value) {
        logger.entry(value);
        browser = value;
    }

    @Deprecated
    public static STAFDriver getInstance(String browser) {
        if (stafDriver == null) {
            stafDriver = new STAFDriver(browser);

        }
        return stafDriver;
    }

    @Deprecated
    public static STAFDriver getInstance() {

        if (stafDriver == null) {
            stafDriver = new STAFDriver(STAFConstant.FIREFOX);
            // setiDriver(stafDriver);
            logger.debug("Firefox browser will be used if no browser name is passed to getInstance");
        }
        logger.debug("Browser selected is : " + getBrowser());
        return stafDriver;
    }

    public void setAsHead() {
        System.out.println(this);
        STAFManager.putHeadPointer(this);
    }

    @Override
    public void autopopulate(Object containerName, Class<?> className)
            throws Throwable {

        System.out.println("Pass object of screenobject instead of class");

    }

    @Deprecated
    public void autopopulate(Object containerName, Object SO) throws Throwable {
        Map<String, String> populateData = new XMLReader()
                .getContainer(containerName.toString());

        Class<?> ScreenObject = SO.getClass();
        if (ScreenObject.getAnnotation(Widgets.class) != null) {
            Class<?>[] ScreenObjectInners = ScreenObject.getDeclaredClasses();
            for (Class<?> ScreenObjectInner : ScreenObjectInners) {
                if (ScreenObjectInner.getAnnotation(Widgets.class) != null) {
                    for (Map.Entry<String, String> entry : populateData
                            .entrySet()) {
                        String s1 = entry.getKey();
                        String s2 = entry.getValue();
                        System.out.println(s1);
                        System.out.println(s2);
                        TextBox t = (TextBox) ScreenObjectInner
                                .getDeclaredField(s1).get(null);
                        t.populate(s2);
                        // t.sendKeys(s2);
                    }
                }
            }

        }

    }

    public void autoPopulate(Object containerName, Object SO) throws Throwable {
        Map<String, String> populateData = new XMLReader()
                .getContainer(containerName.toString());

        Class<?> ScreenObject = SO.getClass();
        if (ScreenObject.getAnnotation(Widgets.class) != null) {
            Class<?>[] ScreenObjectInners = ScreenObject.getDeclaredClasses();
            for (Class<?> ScreenObjectInner : ScreenObjectInners) {
                if (ScreenObjectInner.getAnnotation(Widgets.class) != null) {
                    for (Map.Entry<String, String> entry : populateData
                            .entrySet()) {
                        String s1 = entry.getKey();
                        String s2 = entry.getValue();
                        System.out.println(s1);
                        System.out.println(s2);
                        TextBox t = (TextBox) ScreenObjectInner
                                .getDeclaredField(s1).get(null);
                        t.populate(s2);
                        // t.sendKeys(s2);
                    }
                }
            }

        }

    }

    public void autoVerify(IDataContainer dataContainer, Object so) throws Throwable {
        Map<String,String> dataMap = dataContainer.get();
        new Verify().verifyMap(dataMap,so);
    }

    @Deprecated
    public void autoVerifyMap(IDataContainer dataContainer,Object so){
        Map<String,String> dataMap = dataContainer.get();
        new Verify().verifyMap(dataMap,so);
    }

    public void cookieVerify(Object containerName) {

        HashMap<String, List<String>> verifyCookie = new XMLReader()
                .getCookieContainer(containerName.toString());

        STAFCookie cookie = new STAFCookie();
        if (verifyCookie.get("NAME") != null) {
            cookie.verifyName(verifyCookie.get("NAME"));
        }
        if (verifyCookie.get("DOMAIN") != null) {
            cookie.verifyDomain(verifyCookie.get("DOMAIN"));
        }

    }

    @Override
    public XML getConfig() {

        return STAFRunner.getConfigXml();
    }

    @Override
    public XML getData() {
        return STAFRunner.getDataXml();
    }

    @Override
    public void setData(String dataPath) {

        logger.entry();

        new FileUtil().createData(dataPath);

        /*try {
            SAXBuilder builder = new SAXBuilder();
            //	File xmlFile = data File(getInfo().get(STAFConstant.CONFIG_KEY).toString());
            String currentDirectory = System.getProperty("user.dir");
            System.out.println("*****************" + currentDirectory);
            File xmlFile = new File(currentDirectory + dataPath);
            STAFRunner.setDataDocument((Document) builder.build(xmlFile));
            System.out.println("xmlFile = " + xmlFile);
            System.out.println("STAFRunner.getDataDocument() = " + STAFRunner.getDataDocument());
            STAFRunner.getXmlMap().put(STAFRunner.getDataXml(),STAFRunner.getDataDocument());

        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }*/


    }

    /*@Override
    public void setCongif(String configPath) {
        logger.entry(configPath);

        try {
            SAXBuilder builder = data SAXBuilder();
            File xmlFile = data File(configPath);
            configDocument = (Document) builder.build(xmlFile);

        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }

    }*/

}
