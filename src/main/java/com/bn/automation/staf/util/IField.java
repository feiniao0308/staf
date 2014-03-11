package com.bn.automation.staf.util;

import org.jdom2.Element;

public interface IField {
	
	Element geteField();
	void seteField(Element eField);
	String[][] extractData();

}
