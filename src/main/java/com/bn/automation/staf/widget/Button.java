package com.bn.automation.staf.widget;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;


public class Button extends STAFElement implements IButton {

	private static final Logger logger = LogManager.getLogger();

	public Button(String widgetProperty) {

		super(widgetProperty);
		logger.debug("Widget string passed : " + widgetProperty);

	}

	public WebElement getButton(){
		return getStafElement();
		
		
	}

    public WebElement waitBeforeGetButton(){
        return waitAndGetStafElement();
    }

    @Override
    public void click(){
        System.out.println("inside click of button class");

        waitBeforeGetButton().click();
    }
	
}
