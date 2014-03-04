package com.bn.automation.staf.util;

import java.util.HashMap;

public interface IAttribute {
	
	HashMap<String,String> get();
	
	String getAttributeValue(String attName);
	
	IAttribute getAttribute(String attName);

}
