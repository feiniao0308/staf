package com.bn.automation.staf.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.ElementFilter;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

import com.bn.automation.staf.core.STAFDriver;

public class XMLReader {
	
	private String dataContainerElementName = "datacontainer";
	private String infoContainerElementName = "infocontainer";
	private String dataElementName = "data";
	private String infoElementName = "info";
	private String nameAttribute = "name";
	private String valueAttribute = "value";
	

	public String getDataValue(String dataName) {

		String currentDirectory = System.getProperty("user.dir");
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(currentDirectory
				+ "/src/test/resources/data/eanData.xml");
		try {

			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			System.out.println(rootNode.toString());
			List<Element> dataLists = rootNode.getChildren("container");
			for (Element dataList : dataLists) {
				System.out.println("loop list: " + dataList);
			}
			System.out.println("list: " + dataLists);
			Element eanNode = rootNode.getChild("field");
			System.out.println(eanNode.getAttributeValue("value"));

			return eanNode.getAttributeValue("value");

		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}

		return null;

	}

	public List<Element> getContainerList(String containerName) {

		return null;
	}

	public List<Element> getDataContainerList() {
		return null;
	}

	public List<Element> getInfoContainerList() {
		return null;
	}

	@SuppressWarnings("rawtypes")
	public void getValue() {
		System.out.println("inside getvalue");
		String currentDirectory = System.getProperty("user.dir");
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(currentDirectory
				+ "/src/test/resources/data/data1.xml");
		try {

			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			Element containerNode = rootNode.getChild("container");
			Iterator eanNode = containerNode.getDescendants(new ElementFilter(
					"data"));

			while (eanNode.hasNext()) {
				Element et = (Element) eanNode.next();
				System.out.println(et.getAttributeValue("value"));
			}
			Iterator itr = document.getDescendants();
			/*while (itr.hasNext()) {
				Content c = (Content) itr.next();

				// System.out.println(c);
			}*/

			System.out.println("****");
			itr = document.getDescendants(new ElementFilter("container"));

			while (itr.hasNext()) {
				// Content c = (Content) itr.next();
				Element e = (Element) itr.next();
				// System.out.println(c);
				System.out.println(e.getAttributeValue("name"));
			}
			// System.out.println(eanNode.getAttributeValue("value"));

		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}

	}

	public void getXpathValue() {

		String currentDirectory = System.getProperty("user.dir");
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(currentDirectory
				+ "/src/test/resources/data/xpathdata.xml");

		try {
			System.out.println("inside getxpathvalue");
			Document document = (Document) builder.build(xmlFile);
			String query = "//*[@name= 'Critic User']";
			XPathExpression<Element> xpe = XPathFactory.instance().compile(
					query, Filters.element("url"));
			for (Element urle : xpe.evaluate(document)) {
				System.out.println("inside for loop");
				System.out.printf("This Element has name '%s' and text '%s'\n",
						urle.getName(), urle.getValue());
			}

		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}

	}

	public String getDataValue(String dataFileLocation, String testCaseID, String dataName) {
		
		System.out.println("location : " + dataFileLocation);
		System.out.println("testcaseID : " + testCaseID);
		System.out.println("dataName : " + dataName);
		String currentDirectory = System.getProperty("user.dir");
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(currentDirectory
				+ dataFileLocation);

		try {
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			List<Element> containersNode = rootNode.getChildren();
			
			for(Element containerNode:containersNode){
				System.out.println(containerNode.getAttributeValue(nameAttribute));
				if(containerNode.getAttributeValue(nameAttribute).equals(testCaseID)){
					List<Element> dataContainersNode = containerNode.getChildren(dataContainerElementName);
					for(Element dataContainerNode:dataContainersNode){
						List<Element> datasNode = dataContainerNode.getChildren(dataElementName);
						for(Element dataNode:datasNode){
							System.out.println(dataNode.getAttributeValue(nameAttribute));
							if(dataNode.getAttributeValue(nameAttribute).equals(dataName)){
								System.out.println(dataNode.getAttributeValue(valueAttribute));
								return dataNode.getAttributeValue(valueAttribute);
								
							}
						}
					}
				}
			}

		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
		return null;
	}
	
	public String getInfoValue(String dataFileLocation, String testCaseID, String infoName) {

		String currentDirectory = System.getProperty("user.dir");
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(currentDirectory
				+ dataFileLocation);

		try {
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			List<Element> containersNode = rootNode.getChildren();
			
			for(Element containerNode:containersNode){
				System.out.println(containerNode.getAttributeValue(nameAttribute));
				if(containerNode.getAttributeValue(nameAttribute).equals(testCaseID)){
					List<Element> dataContainersNode = containerNode.getChildren(infoContainerElementName);
					for(Element dataContainerNode:dataContainersNode){
						List<Element> datasNode = dataContainerNode.getChildren(infoElementName);
						for(Element dataNode:datasNode){
							System.out.println(dataNode.getAttributeValue(nameAttribute));
							if(dataNode.getAttributeValue(nameAttribute).equals(infoName)){
								System.out.println(dataNode.getAttributeValue(valueAttribute));
								return dataNode.getAttributeValue(valueAttribute);
								
							}
						}
					}
				}
			}

		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
		return null;
	}
	
	public HashMap<String,String> getContainer(String containerName) throws Throwable{
		
		STAFDriver driver = STAFDriver.getInstance();
		String dataFileLocation = driver.getDataFileLocation();
		HashMap<String,String> Container = new HashMap<String,String>();
		String currentDirectory = System.getProperty("user.dir");
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(currentDirectory
				+ dataFileLocation);
		try {
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			List<Element> containersNode = rootNode.getChildren();
			
			for(Element containerNode:containersNode){
				System.out.println(containerNode.getAttributeValue(nameAttribute));
				if(containerNode.getAttributeValue(nameAttribute).equals(containerName)){
					List<Element> dataContainersNode = containerNode.getChildren("field");
					for(Element dataContainerNode:dataContainersNode){
						Container.put(dataContainerNode.getAttributeValue("name"), dataContainerNode.getAttributeValue("value"));
						System.out.println(dataContainerNode.getAttributeValue("name"));
						System.out.println(dataContainerNode.getAttributeValue("value"));
					}
				}
			}
								
							

		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
		return Container;
		
		
	}
}
