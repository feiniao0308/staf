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
	public static String browser = String
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

	public static void main(String[] args) throws MalformedURLException,
			InterruptedException {

		logger.info("Script to be executed in : " + browser);
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

		if (grid) {
			if (browser.toLowerCase()
					.equals(STAFConstant.FIREFOX.toLowerCase())) {
				DesiredCapabilities capability = DesiredCapabilities.firefox();
				driver = new RemoteWebDriver(new URL(
						"http://localhost:4444/wd/hub"), capability);

			}

		} else {
			driver = new FirefoxDriver();
		}

		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		Thread.sleep(5000L);
		driver.quit();
	}

}
