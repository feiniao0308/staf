package com.bn.automation.staf.util;

import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.output.Format;

public class XMLWriter {
	Date date= new Date();
	 String path = System.getProperty("user.dir");

	public void createXMLroot(){
		try {
			 String path = System.getProperty("user.dir");
			Element staflog = new Element("staflog");
			Document doc = new Document(staflog);
		//	doc.setRootElement(company);
			addTCDetails(doc);
			addTCDetails(doc);
			addTCDetails(doc);
			addTCDetails(doc);
			addTCDetails(doc);
			addTCDetails(doc);
			addTCDetails(doc);
		
			
			
			
			
			/*Element testcase = data Element("testcase");
		//	staff.setAttribute(data Attribute("id", "1"));
			testcase.addContent(data Element("name").setText("Verify Navigation Bar"));
			testcase.addContent(data Element("time").setText("10s"));
			testcase.addContent(data Element("passcount").setText("11"));
			testcase.addContent(data Element("failcount").setText("2"));
	 
			doc.getRootElement().addContent(testcase);
	 
			Element staff2 = data Element("staff");
			staff2.setAttribute(data Attribute("id", "2"));
			staff2.addContent(data Element("firstname").setText("low"));
			staff2.addContent(data Element("lastname").setText("yin fong"));
			staff2.addContent(data Element("nickname").setText("fong fong"));
			staff2.addContent(data Element("salary").setText("188888"));
	 
			doc.getRootElement().addContent(staff2);*/
	 
			// data XMLOutputter().output(doc, System.out);
			XMLOutputter xmlOutput = new XMLOutputter();
	 
			// display nice nice
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter(path+"/target/STAFlog.xml"));
	 
			System.out.println("File Saved!");
		  } catch (IOException io) {
			System.out.println(io.getMessage());
		  }
	}
	
	public void addTCDetails(Document doc){
			Element testcase = new Element("testcase");
		//	staff.setAttribute(data Attribute("id", "1"));
			testcase.addContent(new Element("name").setText("Verify Navigation Bar"));
			testcase.addContent(new Element("time").setText("10s"));
			testcase.addContent(new Element("passcount").setText("11"));
			testcase.addContent(new Element("failcount").setText("2"));
			doc.getRootElement().addContent(testcase);
	}
	
	public void addTestStep(Document doc, String message){
		Element teststep = new Element("teststep");
		//	staff.setAttribute(data Attribute("id", "1"));
			teststep.addContent(new Element("timestamp").setText(new Timestamp(date.getTime()).toString()));
			teststep.addContent(new Element("description").setText("entry params(FirefoxDriver: firefox on XP (3d913a92-d5e9-4c86-a87b-f7c0dc633fac), 1, /src/test/resources/data/QAS.xml, 6000)"));
			teststep.addContent(new Element("result").setText("PASSED"));
			doc.getRootElement().addContent(teststep);
	}
	
	public void addTestStep(){
		try {
			SAXBuilder builder = new SAXBuilder();
			File xmlFile = new File(path+"/target/STAFlog.xml");
	 
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			
			Element teststep = new Element("teststep");
			//	staff.setAttribute(data Attribute("id", "1"));
				teststep.addContent(new Element("timestamp").setText(new Timestamp(date.getTime()).toString()));
				teststep.addContent(new Element("description").setText("entry params(FirefoxDriver: firefox on XP (3d913a92-d5e9-4c86-a87b-f7c0dc633fac), 1, /src/test/resources/data/QAS.xml, 6000)"));
				teststep.addContent(new Element("result").setText("PASSED"));
				rootNode.addContent(teststep);
				//doc.getRootElement().addContent(teststep);
				
				
				XMLOutputter xmlOutput = new XMLOutputter();
				 
				// display nice nice
				xmlOutput.setFormat(Format.getPrettyFormat());
				xmlOutput.output(document, new FileWriter(path+"/target/STAFlog.xml"));
		 
				System.out.println("File Saved!");
		} catch (IOException io) {
			System.out.println(io.getMessage());
		  } catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void createStafLogRoot(){
		try {
			Element stafLogRoot = new Element("StafLogRoot");
			Document document = new Document(stafLogRoot);
			addTCDetails(document);
			addTCDetails(document);
			addTCDetails(document);
			addTCDetails(document);
			addTCDetails(document);
			
			XMLOutputter xmlOutput = new XMLOutputter();
	 
			// display nice nice
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(document, new FileWriter(path+"/target/STAFlog.xml"));
	 
			System.out.println("StafLog File Created!");
		  } catch (IOException io) {
			System.out.println(io.getMessage());
		  }
		
	}
	
	public void createStafLog(){
		try {
			Element stafLogRoot = new Element("StafLog");
			Document document = new Document(stafLogRoot);
			
			XMLOutputter xmlOutput = new XMLOutputter();
	 
			// display nice nice
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(document, new FileWriter(path+"/target/test.xml"));
	 
			System.out.println("StafLog File Created!");
		  } catch (IOException io) {
			System.out.println(io.getMessage());
		  }
		
	}
}
