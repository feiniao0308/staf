package com.bn.automation.staf.util;

import java.util.HashMap;
import java.util.List;

import org.jdom2.Element;

public interface ITag {
	
	ITag getTag(String tagname);
	List<ITag> getTags(String tagname);
	Element geteTag();
	void seteTag(Element eTag);
	String[][] extractData();
	

}
