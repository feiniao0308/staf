package com.bn.automation.staf.widget;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WidgetPropertyParser {
	
	protected static final String EQUALS = "=";
	private static final Logger logger = LogManager.getLogger();
	
	public static Map<String,String> parseString(String propertyString){
		Map<String,String> properties = new LinkedHashMap<String,String>();
		
		if(propertyString == null){
			return properties;
		}
		
		if(propertyString != null){
			String[] propertyNameValuePair = propertyString.split(EQUALS);
			String propertyName = propertyNameValuePair[0];
			String propertyValue = propertyNameValuePair[1];
			logger.debug("Widget's property is set by locator type->" + propertyName + " and with value->" + propertyValue);
			properties.put(propertyName, propertyValue);
		}
		return properties;
	}

}
