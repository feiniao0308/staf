package com.bn.automation.staf.util;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom2.Element;

public class DataContainer implements IDataContainer{
	
	private Element eDataContainer;
	private static final Logger logger = LogManager.getLogger(DataContainer.class);

	@Override
	public IField getField(String fieldName) {
		return this.getField(fieldName);
	}

	@Override
	public ICookie getCookie(String cookieProperty) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Element geteDataContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void seteDataContainer(Element eDataContainer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IField> getFields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ICookie> getCookies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITag getTag(String tagName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ITag> getTags(String tagName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[][] extractData() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	
}
