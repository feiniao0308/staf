package com.bn.automation.staf.widget;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bn.automation.staf.util.XMLReader;

public class TextBox implements WebElement{
	
	public By by;
	public String widgetName;
	public WebElement webElement;
	
	public TextBox(By by, String widgetName){
		this.by = by;
		this.widgetName = widgetName;
		this.webElement = findElement(by);	
	}
	
	public void populate(WebDriver driver,String fileLocation, String testCaseID){
		System.out.println("filelocation : " + fileLocation);
		System.out.println("testcaseID : " + testCaseID);
		System.out.println("inside populate of textbox");
	//	driver.findElement(by);
		System.out.println(by);
		System.out.println(widgetName);
		System.out.println(driver.findElement(by).getTagName());
	//	System.out.println(new XMLReader().getDataValue(widgetName));
		driver.findElement(by).sendKeys(new XMLReader().getDataValue(fileLocation, testCaseID, widgetName));
	}
	

	public void populate() {
		// TODO Auto-generated method stub
		
	}

	public void autoPopulate() {
		// TODO Auto-generated method stub
		
	}

	public void verify() {
		// TODO Auto-generated method stub
		
	}

	public void autoVerify() {
		// TODO Auto-generated method stub
		
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void click() {
		
		// TODO Auto-generated method stub
		
	}

	public WebElement findElement(By arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<WebElement> findElements(By arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAttribute(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCssValue(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Point getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	public Dimension getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTagName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isSelected() {
		// TODO Auto-generated method stub
		return false;
	}

	public void sendKeys(CharSequence... arg0) {
		// TODO Auto-generated method stub
		System.out.println("inside sendkeys of textbox");
		findElement(by).sendKeys("hi");
	}

	public void submit() {
		// TODO Auto-generated method stub
		
	}

}
