package com.bn.automation.staf.core;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.bn.automation.staf.helpers.Clock;
import com.bn.automation.staf.widget.IWidget;

public abstract class IScript {

	public WebDriver iDriver;
	public IWidget widget;
	private static String browser;
	private String testCaseID;
	private String dataFileLocation;
	protected static Logger logger = LogManager.getLogger();
	Clock clock = new Clock();
	STAFLogger stafLogger = new STAFLogger();

	public IScript() {
		logger.info("Selenium Test Automation Framework - "
				+ clock.getCurrentDateTime());
		logger.info("Version 1.0");
		logger.info("Some class name");
		logger.info("Some data xml file");
	}

	
	/**
	 * @param URL
	 */
	@BeforeMethod
	@Parameters("URL")
	public void setup(String URL) {

		iDriver.get(URL);
		iDriver.manage().deleteAllCookies();

	}

	/**
	 * @throws InterruptedException
	 */
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000L);
		iDriver.quit();

	}

	@AfterClass
	public void closeAll() {
	}

	@AfterSuite
	public void closeAllSuite() throws IOException {
		logger.info("Closing the log file and generating Staf report");
		stafLogger.closeStafLog();
		stafLogger.convertXMLToHTML();
		stafLogger.openStafReport();
	}

	public String getTestCaseID() {
		return logger.exit(this.testCaseID);
	}

	public void setTestCaseID(String value) {
		logger.entry(value);
		this.testCaseID = value;
	}

	public String getDataFileLocation() {
		return logger.exit(this.dataFileLocation);
	}

	public void setDataFileLocation(String value) {
		logger.entry(value);
		this.dataFileLocation = value;
	}
	
	public static String getBrowser() {
		return logger.exit(browser);
	}

	
	public static void setBrowser(String value) {
		logger.entry(value);
		browser = value;		
	}


	

}
