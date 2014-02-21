package com.bn.automation.staf.widget;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.bn.automation.staf.core.STAFDriver;

public class Label extends STAFElement implements ITextBox {
	
	private static final Logger logger = LogManager.getLogger(Label.class);

	public Label(String widgetProperty) {
		super(widgetProperty);
		logger.debug("Widget string passed : " + widgetProperty);
	}
	
	public WebElement getLabel() {
		return getStafElement();

	}
	
	/*public void hover(){
		Actions actions = new Actions(STAFDriver.getiDriver());
		actions.moveToElement(getStafElement()).perform();
	}*/

}
