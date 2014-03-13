package com.bn.automation.staf.core;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bn.automation.staf.util.XML;

public class Driver implements STAFiDriver {

	private static final Logger logger = LogManager.getLogger(Driver.class);
	protected String testCaseID;
	protected String dataFileLocation;
	protected String URL;

	protected STAFDriver getHeadSDriver() {
		logger.debug("Get head/current instance of STAFDriver from the Head Pointer Map<HEAD,STAFDriver> ");
		return logger.exit(STAFManager.getHeadPointer().get(STAFManager.getHead()));
	}

	private WebDriver getHeadWDriver() {
		logger.debug("Get head/current instance of WebDriver from the Tail Pointer Map<STAFDriver,WebDriver> using the head instance of STAFDriver ->" + this );
		return logger.exit(STAFManager.getTailPointer().get(getHeadSDriver()));
	}
	
	private WebDriver getThisWDriver(){
		logger.debug("Get instance of WebDriver from the Tail Pointer Map<STAFDriver,WebDriver> using this instance of STAFDriver  ->" + this);
		return logger.exit(STAFManager.getTailPointer().get(this));
	}

	@Override
	public void close() {
		logger.entry();
		logger.debug("this instance of driver will be closed");
		getThisWDriver().close();

	}

	@Override
	public WebElement findElement(By by){
		logger.entry();
		logger.debug("Find WebElement from this instance of driver using : " + by);
		return logger.exit(getThisWDriver().findElement(by));
	}

	@Override
	public List<WebElement> findElements(By by) {
		logger.entry();
		logger.debug("Find List of WebElements from this instance of driver using : " + by);
		return logger.exit(getThisWDriver().findElements(by));
	}

	@Override
	public void get(String url) {
		logger.entry();
		logger.debug("Open passed URL : " + url + " in data browser window");
		getThisWDriver().get(url);
	}

	@Override
	public String getCurrentUrl() {
		logger.entry();
		logger.debug("");
		return getThisWDriver().getCurrentUrl();
	}

	@Override
	public String getPageSource() {
		logger.entry();
		logger.debug("");
		return getThisWDriver().getPageSource();
	}

	@Override
	public String getTitle() {
		logger.entry();
		logger.debug("");
		return getThisWDriver().getTitle();
	}

	@Override
	public String getWindowHandle() {
		logger.entry();
		logger.debug("");
		return getThisWDriver().getWindowHandle();
	}

	@Override
	public Set<String> getWindowHandles() {
		logger.entry();
		logger.debug("");
		return getThisWDriver().getWindowHandles();
	}

	@Override
	public Options manage() {
		logger.entry();
		logger.debug("");
		return getThisWDriver().manage();
	}

	@Override
	public Navigation navigate() {
		logger.entry();
		logger.debug("");
		return getThisWDriver().navigate();
	}

	@Override
	public void quit() {
		logger.entry();
		logger.debug("");
		//TODO check whether its working or not
		getThisWDriver().quit();
	}

	@Override
	public TargetLocator switchTo() {
		logger.entry();
		logger.debug("");
		return getThisWDriver().switchTo();
	}

	@Override
	public String getTestCaseID() {
		logger.entry();
		logger.debug("");
		return logger.exit(this.testCaseID);
	}

	
	@Override
	public void setTestCaseID(String value) {
		logger.debug("");
		logger.entry(value);
		this.testCaseID = value;
	}

	@Deprecated
	@Override
	public String getDataFileLocation() {
		return logger.exit(this.dataFileLocation);
	}

	@Deprecated
	@Override
	public void setDataFileLocation(String value) {
		logger.entry(value);
		this.dataFileLocation = value;
	}

	@Deprecated
	@Override
	public String getURL() {
		return logger.exit(this.URL);
	}

	@Deprecated
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
		// TODO remove this or re route by passing SO2 obj

	}

	@Override
	public XML getConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XML getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCongif(String configPath) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setData(String dataPath) {
		// TODO Auto-generated method stub
		
	}

}
