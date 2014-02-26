package com.bn.automation.staf.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

		String configPath = IScript.info.get(STAFConstant.CONFIG_KEY)
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
				System.out.println(fieldNode
						.getAttributeValue(STAFConstant.NAME));
				if (fieldNode.getAttributeValue(STAFConstant.NAME).equals(
						fieldName)) {
					fieldValue = fieldNode
							.getAttributeValue(STAFConstant.VALUE);
					logger.debug("field name->" + fieldName + " & value->"
							+ fieldValue);
				}
			}

		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
		return fieldValue;

	}

}
