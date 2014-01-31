package com.bn.automation.staf.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.bn.automation.staf.widget.IWidget;

@SuppressWarnings("unused")
public abstract class IDriver{
	public WebDriver iDriver;
	public IWidget widget;
	private String testCaseID;
	private String dataFileLocation;
	
	public IDriver() {
		// TODO Auto-generated constructor stub
		iDriver = new FirefoxDriver();
		//widget = new IWidget();
		setTestCaseID("TC001");
		dataFileLocation = "/src/test/resources/data/data1.xml";
	}
	
	public String getTestCaseID(){
		return this.testCaseID;
	}
	
	public void setTestCaseID(String value){
		this.testCaseID = value;
	}
	
	

}
