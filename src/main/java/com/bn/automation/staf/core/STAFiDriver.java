package com.bn.automation.staf.core;

import org.openqa.selenium.WebDriver;

import com.bn.automation.staf.util.IXML;

public interface STAFiDriver extends WebDriver{
	String getTestCaseID();
	void setTestCaseID(String value);
	String getDataFileLocation();
	void setDataFileLocation(String value);
	String getURL();
	void setURL(String value);
	//String getBrowser();
	//void setBrowser(String value);
	
	Object getDriver();
	void setDriver();
	void autopopulate(Object containerName, Class<?> className)
			throws Throwable;
	
	IXML getConfig();
	IXML getData();
	
	void setCongif(String configPath);
	void setData(String dataPath);
	
	

}
