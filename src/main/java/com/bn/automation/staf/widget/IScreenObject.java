package com.bn.automation.staf.widget;

import org.openqa.selenium.WebElement;

public interface IScreenObject extends WebElement{
	
	public void populate();
	public void autoPopulate();
	public void verify();
	public void autoVerify();
	

}
