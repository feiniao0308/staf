package com.bn.automation.staf.widget;

import com.bn.automation.staf.core.STAFDriver;
import com.bn.automation.staf.core.STAFManager;
import com.bn.automation.staf.helpers.STAFConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class STAFElement extends WidgetInfo implements STAFiElement {

    private static final Logger logger = LogManager.getLogger();
    private static WebElement element = null;
    private static By by = null;

    public STAFElement(String widgetProperty) {
        super(widgetProperty);
    }

    public static STAFDriver getStafManager() {
        return STAFManager.getHeadSD();
    }

    public WebElement getStafElement() {
        logger.trace("by->" + getByElement());
        return getStafManager().findElement(getByElement());

    }

    public WebElement waitAndGetStafElement() {
        logger.trace("by->" + getByElement());
        return getStafManager().waitAndFindElement(getByElement());

    }

    public By getByElement() {
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
        return this.getStafElement();

    }


    public void hover(){
        Actions actions = new Actions(STAFManager.getTailPointer().get(STAFManager.getHeadSD()));
        actions.moveToElement(getStafElement()).perform();
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

    public boolean isPresent() {
        boolean isPresent = true;

        try {
            STAFManager.getTailPointer().get(STAFManager.getHeadSD()).findElement(getByElement());
        } catch (Exception e) {

            isPresent = false;
        }
        return isPresent;

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
