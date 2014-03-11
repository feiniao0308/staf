package com.bn.automation.staf.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;

import com.bn.automation.staf.core.STAFDriver;
import com.bn.automation.staf.core.STAFRunner;
import com.bn.automation.staf.helpers.STAFConstant;
import com.bn.automation.staf.helpers.XMLConstant;

public class XML implements IXML {

	private static final Logger logger = LogManager.getLogger(XML.class);

	@Override
	public IDataContainer getDataContainer(String containerName) {

		System.out.println("hello from getDContianer of XML");
		return null;
	}

	/*@Override
	public IField getField(String fieldName) {
		
		IField f = new Field();
		System.out.println("inside field");
		System.out.println(STAFRunner.getConfigMap().get(this).getRootElement()
				.getAttributes());
		Element rootNode = STAFRunner.getConfigMap().get(this).getRootElement();

		List<Element> fieldNodes = rootNode.getChildren(XMLConstant.FIELD);
		for (Element fieldNode : fieldNodes) {
			System.out.println(fieldNode);
			logger.debug("XML : Field name->"
					+ fieldNode.getAttributeValue(XMLConstant.NAME)
					+ " | value->"
					+ fieldNode.getAttributeValue(XMLConstant.VALUE));
			if(fieldNode.getAttributeValue(XMLConstant.NAME).equals(fieldName)){
				f.setField(fieldNode);
			}
		}

		// TODO Auto-generated method stub
		return f;
		//getTag("field").
		
		return null;
	}*/
	
	
	public Element getField2(String fieldName) {
		
		IField value = new Field();
		Element e = null;
		System.out.println("inside field");
		System.out.println(STAFRunner.getConfigMap().get(this).getRootElement()
				.getAttributes());
		Element rootNode = STAFRunner.getConfigMap().get(this).getRootElement();

		List<Element> fieldNodes = rootNode.getChildren(XMLConstant.FIELD);
		for (Element fieldNode : fieldNodes) {
			System.out.println(fieldNode);
			logger.debug("XML : Field name->"
					+ fieldNode.getAttributeValue(XMLConstant.NAME)
					+ " | value->"
					+ fieldNode.getAttributeValue(XMLConstant.VALUE));
			
			if(fieldNode.getAttributeValue(XMLConstant.NAME).equals(fieldName)){
				e = fieldNode;
			}
			
		}

		// TODO Auto-generated method stub
		return e;
	}


	/*@Override
	public ICookie getCookie(String cookieProperty) {
		
		List<ITag> cookieNodes = getTagNames(XMLConstant.COOKIE);
		String cookieValue = null;
		for(ITag cookieNode : cookieNodes){
			if(cookieNode.geteTagName().getAttributeValue(XMLConstant.PROPERTY).equals(cookieProperty)){
				cookieValue = cookieNode.geteTagName().getAttributeValue(XMLConstant.VALUE);
			}
		}
		
		return cookieValue;
		return null;
	}

	@Override
	public ITag getTag(String tagname) {
		logger.entry(tagname);
		logger.debug("");

		ITag t = new Tag();
		System.out.println("inside getTagName");
		System.out.println(STAFRunner.getConfigMap().get(this).getRootElement()
				.getAttributes());
		Element rootNode = STAFRunner.getConfigMap().get(this).getRootElement();

		Element tagNode = rootNode.getChild(tagname);
		System.out.println(tagNode);
		t.seteTag(tagNode);
		return t;
	}

	@Override
	public List<ITag> getTags(String tagname) {
		System.out.println("inside gettagnames of xml");

		List<ITag> tList = new ArrayList<ITag>();
		System.out.println("inside getTagName");
		System.out.println(STAFRunner.getConfigMap().get(this).getRootElement()
				.getAttributes());
		Element rootNode = STAFRunner.getConfigMap().get(this).getRootElement();

		List<Element> tagNodes = rootNode.getChildren(tagname);
		for(Element tagNode : tagNodes){
			System.out.println(tagNode);
			logger.debug("XML : Tag Name->" + tagNode);
			ITag t = new Tag();
			t.seteTag(tagNode);
			tList.add(t);
		}
		return tList;
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
	public List<IDataContainer> getDataContainers() {
		// TODO Auto-generated method stub
		return null;
	}*/

	
	

}
