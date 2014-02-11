package com.bn.automation.staf.widget;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class Label extends STAFElement implements ITextBox {
	
	private static final Logger logger = LogManager.getLogger(Label.class);

	public Label(String widgetProperty) {
		super(widgetProperty);
		logger.debug("Widget string passed : " + widgetProperty);
	}
	
	public WebElement getLabel() {
		return getStafElement();

	}

}
