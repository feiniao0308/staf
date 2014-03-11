package com.bn.automation.staf.util;

import java.util.List;

import org.jdom2.Element;

public interface IDataContainer {
	
	Element geteDataContainer();
	void seteDataContainer(Element eDataContainer);
	
	
	IField getField(String fieldName);
	List<IField> getFields();
	ICookie getCookie(String cookieName);
	List<ICookie> getCookies();
	
	ITag getTag(String tagName);
	List<ITag> getTags(String tagName);
	
	String[][] extractData();
	
	
	

}
