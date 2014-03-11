package com.bn.automation.staf.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom2.Element;

import com.bn.automation.staf.core.STAFRunner;

public class Tag implements ITag {

	private Element eTag;
	private static final Logger logger = LogManager.getLogger(Tag.class);

	@Override
	public ITag getTag(String tagname) {
		ITag t = new Tag();
		Element tagNode = this.geteTag().getChild(tagname);
		t.seteTag(tagNode);
		return t; 
	}

	@Override
	public List<ITag> getTags(String tagname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element geteTag() {
		return eTag;
	}

	@Override
	public void seteTag(Element eTag) {
		this.eTag = eTag;		
	}

	@Override
	public String[][] extractData() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
