package com.bn.automation.staf.widget;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TextBox extends STAFElement implements ITextBox {
	
	private static final Logger logger = LogManager.getLogger();
	/*@SuppressWarnings("static-access")
	public TextBox(String locator){
		stafDriver = STAFDriver.getInstance();
		logger.debug("Finding element with locator : " + locator + " in the instance of : " + stafDriver);
		setElement(locator, stafDriver);
		this.element = super.element;
	}*/
	
	public TextBox(String widgetProperty){
		
		super(widgetProperty);
		logger.debug("Widget string passed : " + widgetProperty);
		
		
	}
	
	public WebElement getTextBox(){
		return getStafElement();
		
		
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
	

	public void populate(String value) {
		getTextBox().sendKeys(value);
		// TODO Auto-generated method stub
		
	}

	/*public void autoPopulate() {
		System.out.println("inside autopopulate of textbox");
		getTextBox().
	}*/

	public void verify() {
		// TODO Auto-generated method stub
		
	}

	public void autoVerify() {
		// TODO Auto-generated method stub
		
	}

	


}
