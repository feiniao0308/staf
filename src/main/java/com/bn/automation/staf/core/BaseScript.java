package com.bn.automation.staf.core;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.bn.automation.staf.helpers.STAFConstant;

public abstract class BaseScript {

	STAFiDriver driver;
	private static final Logger logger = LogManager.getLogger();
	STAFLogger stafLogger = new STAFLogger();

	@BeforeMethod
	public void setup() {
		driver = new STAFDriver(STAFConstant.FIREFOX);
		driver.setURL("http://qwecweb01.hq.bn-corp.com/bn/");
		driver.manage().deleteAllCookies();
		driver.get(driver.getURL());

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000L);
		driver.quit();

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

}
