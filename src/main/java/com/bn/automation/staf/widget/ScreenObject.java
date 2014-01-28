package com.bn.automation.staf.widget;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bn.automation.staf.helpers.STAFConstant;
import com.bn.automation.staf.helpers.StringOperation;

public abstract class ScreenObject {

	private static String[] by;
	protected static WebElement element;
	private static String byType;
	private static String byValue;
	private static final Logger logger = LogManager.getLogger();
	protected void setElement(String locator, WebDriver driver){
		if (locator != null) {
			by = new StringOperation().splitWithEqual(locator);
			byType = by[0];
			byValue = by[1];
		} else {
			logger.info("By type and value should be passed as parameter");
		}

		switch (byType) {
		case STAFConstant.BY_ID:
			element = driver.findElement(By.id(byValue));
			logger.debug("Element is identified with type :" + byType + " and value :" + byValue);
			break;
		case STAFConstant.BY_NAME:
			element = driver.findElement(By.name(byValue));
			logger.debug("Element is identified with type :" + byType + " and value :" + byValue);
			break;
		case STAFConstant.BY_XPATH:
			element = driver.findElement(By.xpath(byValue));
			logger.debug("Element is identified with type :" + byType + " and value :" + byValue);
			break;
		case STAFConstant.BY_CLASS_NAME:
			element = driver.findElement(By.className(byValue));
			logger.debug("Element is identified with type :" + byType + " and value :" + byValue);
			break;
		case STAFConstant.BY_TAG_NAME:
			element = driver.findElement(By.tagName(byValue));
			logger.debug("Element is identified with type :" + byType + " and value :" + byValue);
		case "other2":
		default:
			throw new IllegalArgumentException("Invalid by type : "
					+ byType);
		}
	}
}
