package com.bn.automation.staf.util;

import java.io.*;
import java.net.URL;
import java.util.List;

import com.bn.automation.staf.core.STAFRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.bn.automation.staf.core.IScript;
import com.bn.automation.staf.helpers.STAFConstant;

public class STAFConfig {

	private static final Logger logger = LogManager.getLogger(STAFConfig.class);

	public String getField(String fieldName) throws Throwable {

		String configPath = IScript.getInfo().get(STAFConstant.CONFIG_KEY)
				.toString();
		String currentDirectory = System.getProperty("user.dir");
		SAXBuilder builder = new SAXBuilder();
		String fieldValue = null;
		File file = new File(currentDirectory + configPath);
		try {
			Document document = (Document) builder.build(file);
			Element rootNode = document.getRootElement();
			List<Element> fieldNodes = rootNode.getChildren();

			for (Element fieldNode : fieldNodes) {
				logger.trace("field name and value in congif file is "
						+ fieldNode.getAttributeValue(STAFConstant.NAME) + "->"
						+ fieldNode.getAttributeValue(STAFConstant.VALUE));
				if (fieldNode.getAttributeValue(STAFConstant.NAME).equals(
						fieldName)) {
					fieldValue = fieldNode
							.getAttributeValue(STAFConstant.VALUE);
					logger.debug("field name->" + fieldName + " & value->"
							+ fieldValue);
				}
			}
			
			if(fieldValue == null){
				logger.error("field name : " + fieldName + " is not found in config file");
			}

		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
		
		return fieldValue;

	}
	
	public boolean isFieldPresent(String fieldName) {
		String configPath = IScript.getInfo().get(STAFConstant.CONFIG_KEY)
				.toString();
		String currentDirectory = System.getProperty("user.dir");
		SAXBuilder builder = new SAXBuilder();
		String fieldValue = null;
		boolean isFieldPresent = false;
		File file = new File(currentDirectory + configPath);
		try {
			Document document = (Document) builder.build(file);
			Element rootNode = document.getRootElement();
			List<Element> fieldNodes = rootNode.getChildren();

			for (Element fieldNode : fieldNodes) {
				logger.trace("field name and value in congif file is "
						+ fieldNode.getAttributeValue(STAFConstant.NAME) + "->"
						+ fieldNode.getAttributeValue(STAFConstant.VALUE));
				if (fieldNode.getAttributeValue(STAFConstant.NAME).equals(
						fieldName)) {
					fieldValue = fieldNode
							.getAttributeValue(STAFConstant.VALUE);
					logger.debug("field name->" + fieldName + " & value->"
							+ fieldValue);
				}
			}
			
			if(fieldValue == null){
				logger.error("field name : " + fieldName + " is not found in config file");
				isFieldPresent = false;
			} else {
				logger.error("field name : " + fieldName + " is found in config file");
				isFieldPresent = true;
			}

		} catch (IOException io) {
			logger.error("IOException - Field Name/File not found or something else went wrong");
		} catch (JDOMException jdomex) {
			logger.error("JDOMException - Field Name/File not found or something else went wrong");
		}
		
		return isFieldPresent;
	}

    public void createDocument(String path) {
        InputStream inputStream = null;
        SAXBuilder builder = null;
        try {
            builder = new SAXBuilder();
            //File xmlFile = new File(getInfo().get(STAFConstant.CONFIG_KEY).toString());
            //InputStream is = getClass().getClassLoader().getResourceAsStream("config/Config.xml");
            inputStream = getClass().getClassLoader().getResourceAsStream(path);
            //Reader reader = new InputStreamReader(inputStream);
            STAFRunner.setConfigDocument((Document) builder.build(inputStream));


            //System.out.println("getConfigDocument() = " + STAFRunner.getConfigDocument());
            //STAFRunner.getXmlMap().put(STAFRunner.getConfigXml(), STAFRunner.getConfigDocument());


        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }

    }

}
