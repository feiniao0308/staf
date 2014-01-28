package com.bn.automation.staf.widget;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bn.automation.staf.core.STAFDriver;

public class TextBox extends ScreenObject implements IScreenObject {
	
	private static WebElement element;
	private static STAFDriver stafDriver;
	private static final Logger logger = LogManager.getLogger();
	
	@SuppressWarnings("static-access")
	public TextBox(String locator){
		stafDriver = STAFDriver.getInstance();
		logger.debug("Finding element with locator : " + locator + " in the instance of : " + stafDriver);
		setElement(locator, stafDriver);
		this.element = super.element;
	}
	
	public void populate(WebDriver driver,String fileLocation, String testCaseID){
		/*System.out.println("filelocation : " + fileLocation);
		System.out.println("testcaseID : " + testCaseID);
		System.out.println("inside populate of textbox");
	//	driver.findElement(by);
		System.out.println(by);
		System.out.println(widgetName);
		System.out.println(driver.findElement(by).getTagName());
	//	System.out.println(new XMLReader().getDataValue(widgetName));
		driver.findElement(by).sendKeys(new XMLReader().getDataValue(fileLocation, testCaseID, widgetName));*/
	}
	

	public void populate() {
		// TODO Auto-generated method stub
		
	}

	public void autoPopulate() {
		System.out.println("inside autopopulate of textbox");
		
	}

	public void verify() {
		// TODO Auto-generated method stub
		
	}

	public void autoVerify() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void click() {
		element.click();
	}

	@Override
	public void submit() {
		element.submit();
	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		element.sendKeys(keysToSend);
	}

	@Override
	public void clear() {
		element.clear();

	}

	@Override
	public String getTagName() {
		return element.getTagName();
	}

	@Override
	public String getAttribute(String name) {
		return element.getAttribute(name);
	}

	@Override
	public boolean isSelected() {
		return element.isSelected();
	}

	@Override
	public boolean isEnabled() {
		return element.isEnabled();
	}

	@Override
	public String getText() {
		return element.getText();
	}

	@Override
	public List<WebElement> findElements(By by) {
		return element.findElements(by);
	}

	@Override
	public WebElement findElement(By by) {
		return element.findElement(by);
	}

	@Override
	public boolean isDisplayed() {
		return element.isDisplayed();
	}

	@Override
	public Point getLocation() {
		return element.getLocation();
	}

	@Override
	public Dimension getSize() {
		return element.getSize();
	}

	@Override
	public String getCssValue(String propertyName) {
		return element.getCssValue(propertyName);
	}


}
