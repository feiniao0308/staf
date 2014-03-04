package com.bn.automation.staf.util;

public interface IXML {
	
	IDataContainer getDataContainer(String containerName);
	
	IField getField(String fieldName);
	
	ICookie getCookie(String cookieProperty);
	
	IAttribute getAttribute(String attName);
	
	
	

}
