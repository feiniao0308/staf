package com.bn.automation.staf.core;

import org.openqa.selenium.WebDriver;

public interface STAFiDriver extends WebDriver{
	String getTestCaseID();
	void setTestCaseID(String value);
	String getDataFileLocation();
	void setDataFileLocation(String value);
	String getURL();
	void setURL(String value);
	String getBrowser();
	void setBrowser(String value);
	

}
