package com.bn.automation.staf.core;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.bn.automation.staf.helpers.STAFConstant;

public class STAFDriver extends IScript implements STAFiDriver{

	public static WebDriver iDriver;
	private static String browser;
	private String testCaseID;
	private String dataFileLocation;
	private String URL;
	private static final Logger logger = LogManager.getLogger();
	
	public STAFDriver(String browser) {
		switch (browser) {
		case STAFConstant.FIREFOX:
			setBrowser(STAFConstant.FIREFOX);
			iDriver = new FirefoxDriver();
			logger.info("Firefox browser is set and opened in new window");
			break;
		case STAFConstant.CHROME:
			setBrowser(STAFConstant.CHROME);
			iDriver = new ChromeDriver();
			logger.info("Chrome browser is set and opened in new window");
			break;
		case STAFConstant.IE:
			setBrowser(STAFConstant.IE);
			iDriver = new InternetExplorerDriver();
			logger.info("Internet Explorer browser is set and opened in new window");
			break;
		case STAFConstant.HTML_UNIT:
			setBrowser(STAFConstant.HTML_UNIT);
			iDriver = new HtmlUnitDriver();
			logger.info("HTML unit browser is set and opened in new window");
			break;
		case "other1":
		case "other2":
		default:
			throw new IllegalArgumentException("Invalid browser type : "
					+ browser);
		}
	}

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
	
	public static WebDriver getInstance(){
		
		if(iDriver == null){
			STAFiDriver iDriver = new STAFDriver(STAFConstant.HTML_UNIT);
			logger.debug("STAF Driver is null and creating a new browser driver");
			System.out.println("instance is:" + iDriver);
		}
		return iDriver;
	}

	@Override
	public void get(String url) {
		iDriver.get(url);

	}

	@Override
	public String getCurrentUrl() {
		return iDriver.getCurrentUrl();
	}

	@Override
	public String getTitle() {
		return iDriver.getTitle();
	}

	@Override
	public List<WebElement> findElements(By by) {
		return iDriver.findElements(by);
	}

	@Override
	public WebElement findElement(By by) {
		return iDriver.findElement(by);
	}

	@Override
	public String getPageSource() {
		return iDriver.getPageSource();
	}

	@Override
	public void close() {
		iDriver.close();
	}

	@Override
	public void quit() {
		iDriver.quit();
	}

	@Override
	public Set<String> getWindowHandles() {
		return iDriver.getWindowHandles();
	}

	@Override
	public String getWindowHandle() {
		return iDriver.getWindowHandle();
	}

	@Override
	public TargetLocator switchTo() {
		return iDriver.switchTo();
	}

	@Override
	public Navigation navigate() {
		return iDriver.navigate();
	}

	@Override
	public Options manage() {
		return iDriver.manage();
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

	@SuppressWarnings("static-access")
	@Override
	public String getBrowser() {
		return logger.exit(this.browser);
	}

	@Override
	public void setBrowser(String value) {
		logger.entry(value);
		this.dataFileLocation = value;		
	}

}
