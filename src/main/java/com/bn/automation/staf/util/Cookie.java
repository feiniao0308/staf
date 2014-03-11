package com.bn.automation.staf.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom2.Element;

public class Cookie implements ICookie{

	private Element eCookie;
	private static final Logger logger = LogManager.getLogger(Cookie.class);
	@Override
	public Element geteCookie() {
		return eCookie;
	}
	@Override
	public void seteCookie(Element eCookie) {
		this.eCookie = eCookie;
	}
	@Override
	public String[][] extractData() {
		// TODO Auto-generated method stub
		return null;
	}


	

	

}
