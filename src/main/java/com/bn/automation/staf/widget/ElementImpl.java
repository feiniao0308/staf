package com.bn.automation.staf.widget;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;

public class ElementImpl implements Element{
	
	private final WebElement element;
	
	public ElementImpl(final WebElement element){
		this.element = element;
	}

	public boolean elementWired() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void click(){
		System.out.println("inside click");
		element.click();
	}

	public void submit() {
		// TODO Auto-generated method stub
		
	}

	public void sendKeys(CharSequence... keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public String getTagName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isSelected() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public Point getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	public Dimension getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCssValue(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement getWrappedElement() {
		// TODO Auto-generated method stub
		return null;
	}

	public Coordinates getCoordinates() {
		// TODO Auto-generated method stub
		return null;
	}

}
