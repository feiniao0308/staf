package com.bn.automation.staf.widget;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.bn.automation.staf.core.STAFDriver;
import com.bn.automation.staf.core.STAFManager;
import com.bn.automation.staf.helpers.STAFConstant;

public class STAFElement extends WidgetInfo implements STAFiElement {

	// private static final Map<String,String> elementProperty = null;
	private static WebElement element = null;
	private static By by = null;
	private static final Logger logger = LogManager.getLogger();

	public STAFElement(String widgetProperty) {
		super(widgetProperty);
	}

	public STAFDriver getStafManager() {
		STAFManager stafManager = new STAFManager();
		logger.debug("StafInstance is  : " + stafManager.getInstance());
		return stafManager.getInstance();
		// return STAFDriver.getInstance();
	}

	public WebElement getStafElement() {
		
		System.out.println("by : " + getByElement()); 
		return getStafManager().findElement(getByElement());
		
		/*switch (getPropertyName()) {
		case STAFConstant.BY_ID:
			//by = By.id(getPropertyValue());
			element = getStafManager().findElement(By.id(getPropertyValue()));
			logger.debug("Element is identified with type :"
					+ getPropertyName() + " and value :" + getPropertyValue());
			break;
		case STAFConstant.BY_NAME:
			element = getStafManager().findElement(By.name(getPropertyValue()));
			logger.debug("Element is identified with type :"
					+ getPropertyName() + " and value :" + getPropertyValue());
			break;
		case STAFConstant.BY_XPATH:
			element = getStafManager()
					.findElement(By.xpath(getPropertyValue()));
			logger.debug("Element is identified with type :"
					+ getPropertyName() + " and value :" + getPropertyValue());
			break;
		case STAFConstant.BY_CLASS_NAME:
			element = getStafManager().findElement(
					By.className(getPropertyValue()));
			logger.debug("Element is identified with type :"
					+ getPropertyName() + " and value :" + getPropertyValue());
			break;
		case STAFConstant.BY_TAG_NAME:
			element = getStafManager().findElement(
					By.tagName(getPropertyValue()));
			logger.debug("Element is identified with type :"
					+ getPropertyName() + " and value :" + getPropertyValue());
		case "other2":
		default:
			throw new IllegalArgumentException("Invalid by type : "
					+ getPropertyName());
		}
		return element;*/
	}
	
	public By getByElement(){
		switch (getPropertyName()) {
		case STAFConstant.BY_ID:
			by = By.id(getPropertyValue());
			//element = getStafManager().findElement(By.id(getPropertyValue()));
			logger.debug("Element is identified with type :"
					+ getPropertyName() + " and value :" + getPropertyValue());
			break;
		case STAFConstant.BY_NAME:
			by = By.name(getPropertyValue());
			//element = getStafManager().findElement(By.name(getPropertyValue()));
			logger.debug("Element is identified with type :"
					+ getPropertyName() + " and value :" + getPropertyValue());
			break;
		case STAFConstant.BY_XPATH:
			by = By.xpath(getPropertyValue());
			//element = getStafManager()
			//		.findElement(By.xpath(getPropertyValue()));
			logger.debug("Element is identified with type :"
					+ getPropertyName() + " and value :" + getPropertyValue());
			break;
		case STAFConstant.BY_CLASS_NAME:
			by = By.className(getPropertyValue());
			//element = getStafManager().findElement(
			//		By.className(getPropertyValue()));
			logger.debug("Element is identified with type :"
					+ getPropertyName() + " and value :" + getPropertyValue());
			break;
		case STAFConstant.BY_TAG_NAME:
			by = By.tagName(getPropertyValue());
			//element = getStafManager().findElement(
			//		By.tagName(getPropertyValue()));
			logger.debug("Element is identified with type :"
					+ getPropertyName() + " and value :" + getPropertyValue());
		case "other2":
		default:
			throw new IllegalArgumentException("Invalid by type : "
					+ getPropertyName());
		}
		return by;
	}

	private WebElement getElement() {
		System.out.println("this is : " + this);
		return this.getStafElement();
		//return getStafElement();
		
	}
	
	

	@Override
	public void click() {
		getElement().click();
	}

	@Override
	public void submit() {
		getElement().submit();
	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		getElement().sendKeys(keysToSend);
	}

	@Override
	public void clear() {
		getElement().clear();
	}

	@Override
	public String getTagName() {
		return getElement().getTagName();
	}

	@Override
	public String getAttribute(String name) {
		return getElement().getAttribute(name);
	}

	@Override
	public boolean isSelected() {
		return getElement().isSelected();
	}

	@Override
	public boolean isEnabled() {
		return getElement().isEnabled();
	}

	@Override
	public String getText() {
		return getElement().getText();
	}

	@Override
	public List<WebElement> findElements(By by) {
		return getElement().findElements(by);
	}

	@Override
	public WebElement findElement(By by) {
		return getElement().findElement(by);
	}

	@Override
	public boolean isDisplayed() {
		return getElement().isDisplayed();
	}

	@Override
	public Point getLocation() {
		return getElement().getLocation();
	}

	@Override
	public Dimension getSize() {
		return getElement().getSize();
	}

	@Override
	public String getCssValue(String propertyName) {
		return getElement().getCssValue(propertyName);
	}

}
