package com.bn.automation.staf.util;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom2.Element;

public class Field extends Tag implements IField{
	
	private Element eField;
	private static final Logger logger = LogManager.getLogger(Tag.class);

	@Override
	public String[][] extractData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element geteField() {
		return eField;
	}

	@Override
	public void seteField(Element eField) {
		this.eField = eField;
		
	}

}
