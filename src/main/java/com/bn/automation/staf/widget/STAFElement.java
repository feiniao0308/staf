package com.bn.automation.staf.widget;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.bn.automation.staf.core.STAFDriver;
import com.bn.automation.staf.core.STAFManager;
import com.bn.automation.staf.helpers.STAFConstant;

public class STAFElement extends WidgetInfo implements STAFiElement{
	
	//private static final Map<String,String> elementProperty = null;
	private static WebElement element = null;
	private static final Logger logger = LogManager.getLogger();

	public STAFElement(String widgetProperty) {
		super(widgetProperty);
	}
	
	public STAFDriver getStafManager(){
		STAFManager stafManager = new STAFManager();
		return stafManager.getInstance();
	}
	
	public WebElement getStafElement(){
		switch (getPropertyName()) {
		case STAFConstant.BY_ID:
			element = getStafManager().findElement(By.id(getPropertyValue()));
			logger.debug("Element is identified with type :" + getPropertyName() + " and value :" + getPropertyValue());
			break;
		case STAFConstant.BY_NAME:
			element = getStafManager().findElement(By.name(getPropertyValue()));
			logger.debug("Element is identified with type :" + getPropertyName() + " and value :" + getPropertyValue());
			break;
		case STAFConstant.BY_XPATH:
			element = getStafManager().findElement(By.xpath(getPropertyValue()));
			logger.debug("Element is identified with type :" + getPropertyName() + " and value :" + getPropertyValue());
			break;
		case STAFConstant.BY_CLASS_NAME:
			element = getStafManager().findElement(By.className(getPropertyValue()));
			logger.debug("Element is identified with type :" + getPropertyName() + " and value :" + getPropertyValue());
			break;
		case STAFConstant.BY_TAG_NAME:
			element = getStafManager().findElement(By.tagName(getPropertyValue()));
			logger.debug("Element is identified with type :" + getPropertyName() + " and value :" + getPropertyValue());
		case "other2":
		default:
			throw new IllegalArgumentException("Invalid by type : "
					+ getPropertyName());
		}
		return element;
	}

	@Override
	public void click() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTagName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCssValue(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

}
