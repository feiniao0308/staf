package com.bn.automation.staf.widget;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;

public interface Element extends WebElement,WrapsElement,Locatable{
	boolean elementWired();

	
	//void click();

}
