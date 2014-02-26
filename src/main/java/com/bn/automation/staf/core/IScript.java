package com.bn.automation.staf.core;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bn.automation.staf.helpers.STAFConstant;

public abstract class IScript {

	public static WebDriver driver; // change to stafdriver
	public static String browser_name = String.valueOf(System
			.getProperty(STAFConstant.BROWSER_NAME_ARG));
	public static String url = String.valueOf(System.getProperty(STAFConstant.URL_ARG));
	public static String config = String.valueOf(System.getProperty(STAFConstant.CONFIG_ARG));
	public static String xmldata = String
			.valueOf(System.getProperty(STAFConstant.XML_DATA_ARG));
	public static String log_path = String.valueOf(System
			.getProperty(STAFConstant.LOG_PATH_ARG));
	public static boolean grid = Boolean.valueOf(System.getProperty(STAFConstant.GRID_ARG));
	public static String hub_url = String
			.valueOf(System.getProperty(STAFConstant.HUB_URL_ARG));
	public static String browser_version = String.valueOf(System
			.getProperty(STAFConstant.BROWSER_VERSION_ARG));
	public static String platform = String.valueOf(System
			.getProperty(STAFConstant.PLATFORM_ARG));
	public static String machine_name = String.valueOf(System
			.getProperty(STAFConstant.MACHINE_NAME_ARG));
	public static boolean screenshot = Boolean.valueOf(System
			.getProperty(STAFConstant.SCREENSHOT_ARG));
	private static final String NULL = STAFConstant.NULL;
	public static Map<String, Object> info = new HashMap<String, Object>();
	private static final Logger logger = LogManager.getLogger(IScript.class);

	protected static void setEnv() {
		createInfoMap();
	}

	public IScript() {

	}

	private static void createInfoMap() {
		putInfoMap(STAFConstant.CONFIG_KEY,config);
		putInfoMap(STAFConstant.BROWSER_NAME_KEY,browser_name);
		putInfoMap(STAFConstant.URL_KEY,url);
		putInfoMap(STAFConstant.XML_DATA_KEY,xmldata);
		putInfoMap(STAFConstant.LOG_PATH_KEY,log_path);
		putInfoMap(STAFConstant.GRID_KEY,grid);
		putInfoMap(STAFConstant.HUB_URL_KEY,hub_url);
		putInfoMap(STAFConstant.BROWSER_VERSION_KEY,browser_version);
		putInfoMap(STAFConstant.PLATFORM_KEY,platform);
		putInfoMap(STAFConstant.MACHINE_NAME_KEY,machine_name);
		putInfoMap(STAFConstant.SCREENSHOT_KEY,screenshot);
		
		
	/*	
		info.put("config", config);
		info.put("browser", browser_name);
		info.put("url", url);
		info.put("xmldata", xmldata);
		info.put("logPath", log_path);
		info.put("grid", grid);
		info.put("hubUrl", hub_url);
		info.put("browserVersion", browser_version);
		info.put("platform", platform);
		info.put("machineName", machine_name);
		info.put("screenshot", screenshot);*/

	}

	private static void putInfoMap(String key, Object value) {
		if(!value.equals(NULL)){
			logger.debug("info map is created with key->" + key + " & value->" + value);
			info.put(key, value);
		} else {
			logger.debug("info map is not created for key->" + key + " & value->" + value);
		}
	}

	protected static void viewInfoMap() {
		logger.info("INFO MAP FOR ALL KEYS");
		for (Map.Entry<String, Object> entry : info.entrySet()) {
			System.out.println(entry.getKey().length()+":"+entry.getValue().toString().length());

			System.out
					.println("\t*" + entry.getKey() + "->" + entry.getValue());

		}

	}
	
	

	/*
	 * public static void main(String[] args) throws MalformedURLException,
	 * InterruptedException {
	 * 
	 * logger.info("Script to be executed in : " + browser_name);
	 * logger.info("URL passed is : " + url);
	 * logger.info("Config xml path is : " + config);
	 * logger.info("XML data path is : " + xmldata);
	 * logger.info("HTML log will be generated at : " + log_path);
	 * logger.info("Execution in grid has been set to : " + grid);
	 * logger.info("Grid's HUB URL is  : " + hub_url);
	 * logger.info("Browser version is : " + browser_version);
	 * logger.info("Platform selected is : " + platform);
	 * logger.info("Machine name is : " + machine_name);
	 * logger.info("Take screen shot has set to : " + screenshot);
	 * 
	 * hub_url = hub_url+"/wd/hub";
	 * 
	 * if (grid) { if (browser_name.toLowerCase()
	 * .equals(STAFConstant.FIREFOX.toLowerCase())) { DesiredCapabilities
	 * capability = DesiredCapabilities.firefox(); driver = new
	 * RemoteWebDriver(new URL( hub_url), capability);
	 * 
	 * }
	 * 
	 * } else { driver = new FirefoxDriver(); }
	 * 
	 * driver.get("http://google.com"); System.out.println(driver.getTitle());
	 * Thread.sleep(5000L); driver.quit(); }
	 */

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		IScript.driver = driver;
	}

	public static String getBrowser_name() {
		return browser_name;
	}

	public static void setBrowser_name(String browser_name) {
		IScript.browser_name = browser_name;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		IScript.url = url;
	}

	public static String getConfig() {
		return config;
	}

	public static void setConfig(String config) {
		IScript.config = config;
	}

	public static String getXmldata() {
		return xmldata;
	}

	public static void setXmldata(String xmldata) {
		IScript.xmldata = xmldata;
	}

	public static String getLog_path() {
		return log_path;
	}

	public static void setLog_path(String log_path) {
		IScript.log_path = log_path;
	}

	public static boolean isGrid() {
		return grid;
	}

	public static void setGrid(boolean grid) {
		IScript.grid = grid;
	}

	public static String getHub_url() {
		return hub_url;
	}

	public static void setHub_url(String hub_url) {
		IScript.hub_url = hub_url;
	}

	public static String getBrowser_version() {
		return browser_version;
	}

	public static void setBrowser_version(String browser_version) {
		IScript.browser_version = browser_version;
	}

	public static String getPlatform() {
		return platform;
	}

	public static void setPlatform(String platform) {
		IScript.platform = platform;
	}

	public static String getMachine_name() {
		return machine_name;
	}

	public static void setMachine_name(String machine_name) {
		IScript.machine_name = machine_name;
	}

	public static boolean isScreenshot() {
		return screenshot;
	}

	public static void setScreenshot(boolean screenshot) {
		IScript.screenshot = screenshot;
	}

	public static Logger getLogger() {
		return logger;
	}

}
