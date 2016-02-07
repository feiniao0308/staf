package com.bn.automation.staf.widget;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WidgetInfo implements IWidgetInfo {

	private Map<String, String> propertyMap = null;
	private String propertyMapName = null;
	private String propertyMapValue = null;

	private static final Logger logger = LogManager.getLogger();

	public WidgetInfo(String widgetProperty) {

		propertyMap = WidgetPropertyParser.parseString(widgetProperty);
		logger.debug("Property Map is created with : " + propertyMap);
		setWidgetInfo(propertyMap);
	}

	public void setWidgetInfo(Map<String, String> propertyMap) {

		for (Map.Entry<String, String> entry : propertyMap.entrySet()) {
            logger.trace(entry.getKey() + "=>" + entry.getValue());
			propertyMapName = entry.getKey();
			propertyMapValue = entry.getValue();
			setPropertyName(entry.getKey());
			setPropertyValue(entry.getValue());
		}

		propertyMap = this.propertyMap;
	}

	public Map<String, String> getWidgetInfo() {
		return propertyMap;
	}

	public String getPropertyName() {
		return propertyMapName;
	}

	public void setPropertyName(String name) {

	}

	public String getPropertyValue() {
		return propertyMapValue;
	}

	public void setPropertyValue(String value) {

	}

}
