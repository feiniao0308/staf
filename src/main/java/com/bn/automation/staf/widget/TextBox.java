package com.bn.automation.staf.widget;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class TextBox extends STAFElement implements ITextBox {

	private static final Logger logger = LogManager.getLogger();

	public TextBox(String widgetProperty) {

		super(widgetProperty);
		logger.debug("Widget string passed : " + widgetProperty);

	}

	public WebElement getTextBox() {
		return getStafElement();

	}

	public void populate(String value) {
		getTextBox().sendKeys(value);

	}

	public void verify() {
		// TODO Auto-generated method stub

	}

	public void autoVerify() {
		// TODO Auto-generated method stub

	}

}
