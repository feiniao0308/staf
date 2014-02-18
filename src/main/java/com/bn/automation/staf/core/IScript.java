package com.bn.automation.staf.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.bn.automation.staf.helpers.STAFConstant;

public abstract class IScript {

	public static WebDriver driver; // change to stafdriver
	public static String browser_name = String
			.valueOf(System.getProperty("browser"));
	public static String url = String.valueOf(System.getProperty("url"));
	public static String config = String.valueOf(System.getProperty("config"));
	public static String xmldata = String
			.valueOf(System.getProperty("xmldata"));
	public static String log_path = String.valueOf(System
			.getProperty("log_path"));
	public static boolean grid = Boolean.valueOf(System.getProperty("grid"));
	public static String hub_url = String
			.valueOf(System.getProperty("hub_url"));
	public static String browser_version = String.valueOf(System
			.getProperty("browser_version"));
	public static String platform = String.valueOf(System
			.getProperty("platform"));
	public static String machine_name = String.valueOf(System
			.getProperty("machine_name"));
	public static boolean screenshot = Boolean.valueOf(System
			.getProperty("screenshot"));
	private static final Logger logger = LogManager.getLogger(IScript.class);
	
	public IScript(){
		/*logger.info("Script to be executed in : " + browser_name);
		logger.info("URL passed is : " + url);
		logger.info("Config xml path is : " + config);*/
	}

	public static void main(String[] args) throws MalformedURLException,
			InterruptedException {

		logger.info("Script to be executed in : " + browser_name);
		logger.info("URL passed is : " + url);
		logger.info("Config xml path is : " + config);
		logger.info("XML data path is : " + xmldata);
		logger.info("HTML log will be generated at : " + log_path);
		logger.info("Execution in grid has been set to : " + grid);
		logger.info("Grid's HUB URL is  : " + hub_url);
		logger.info("Browser version is : " + browser_version);
		logger.info("Platform selected is : " + platform);
		logger.info("Machine name is : " + machine_name);
		logger.info("Take screen shot has set to : " + screenshot);
		
		hub_url = hub_url+"/wd/hub";

		if (grid) {
			if (browser_name.toLowerCase()
					.equals(STAFConstant.FIREFOX.toLowerCase())) {
				DesiredCapabilities capability = DesiredCapabilities.firefox();
				driver = new RemoteWebDriver(new URL(
						hub_url), capability);

			}

		} else {
			driver = new FirefoxDriver();
		}

		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		Thread.sleep(5000L);
		driver.quit();
	}

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
