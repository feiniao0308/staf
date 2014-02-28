package com.bn.automation.staf.core;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Driver implements STAFiDriver {

	private static final Logger logger = LogManager.getLogger(Driver.class);
	protected String testCaseID;
	protected String dataFileLocation;
	protected String URL;

	protected static STAFDriver getHeadSDriver() {

		return STAFManager.getHeadPointer().get(STAFManager.getHead());
	}

	private static WebDriver getHeadWDriver() {
		return STAFManager.getTailPointer().get(getHeadSDriver());
	}

	@Override
	public void close() {
		getHeadWDriver().close();

	}

	@Override
	public WebElement findElement(By by) {
		return getHeadWDriver().findElement(by);
	}

	@Override
	public List<WebElement> findElements(By by) {
		return getHeadWDriver().findElements(by);
	}

	@Override
	public void get(String url) {
		getHeadWDriver().get(url);
	}

	@Override
	public String getCurrentUrl() {
		return getHeadWDriver().getCurrentUrl();
	}

	@Override
	public String getPageSource() {
		return getHeadWDriver().getPageSource();
	}

	@Override
	public String getTitle() {
		return getHeadWDriver().getTitle();
	}

	@Override
	public String getWindowHandle() {
		return getHeadWDriver().getWindowHandle();
	}

	@Override
	public Set<String> getWindowHandles() {
		return getHeadWDriver().getWindowHandles();
	}

	@Override
	public Options manage() {
		return getHeadWDriver().manage();
	}

	@Override
	public Navigation navigate() {
		return getHeadWDriver().navigate();
	}

	@Override
	public void quit() {
		//TODO check whether its working or not
		getHeadWDriver().quit();
	}

	@Override
	public TargetLocator switchTo() {
		return getHeadWDriver().switchTo();
	}

	@Override
	public String getTestCaseID() {
		return logger.exit(this.testCaseID);
	}

	@Override
	public void setTestCaseID(String value) {
		logger.entry(value);
		this.testCaseID = value;
	}

	@Override
	public String getDataFileLocation() {
		return logger.exit(this.dataFileLocation);
	}

	@Override
	public void setDataFileLocation(String value) {
		logger.entry(value);
		this.dataFileLocation = value;
	}

	@Override
	public String getURL() {
		return logger.exit(this.URL);
	}

	@Override
	public void setURL(String value) {
		logger.entry(value);
		this.URL = value;
	}

	@Deprecated
	@Override
	public Object getDriver() {
		return null;

	}

	@Deprecated
	@Override
	public void setDriver() {

	}

	@Override
	public void autopopulate(Object containerName, Class<?> className)
			throws Throwable {
		// TODO remove this or re route by passing SO obj

	}

}
