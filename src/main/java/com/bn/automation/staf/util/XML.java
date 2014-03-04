package com.bn.automation.staf.util;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;

import com.bn.automation.staf.core.STAFRunner;
import com.bn.automation.staf.helpers.STAFConstant;

public class XML implements IXML {

	@Override
	public IDataContainer getDataContainer(String containerName) {

		System.out.println("hello from getDContianer of XML");
		return null;
	}

	@Override
	public IField getField(String fieldName) {
		System.out.println("inside field");
		System.out.println(STAFRunner.getConfigMap().get(this).getRootElement()
				.getAttributes());
		Element rootNode = STAFRunner.getConfigMap().get(this).getRootElement();

		List<Element> fieldNodes = rootNode.getChildren("field");
		for (Element fieldNode : fieldNodes) {

			System.out.println(fieldNode.getAttributeValue("name"));
			System.out.println(fieldNode.getAttributeValue("value"));
		}

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICookie getCookie(String cookieProperty) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IAttribute getAttribute(String attName) {
		// TODO Auto-generated method stub
		return null;
	}

}
