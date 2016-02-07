package com.bn.automation.staf.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.filter.Filters;
import org.jdom2.output.XMLOutputter;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

import java.util.Map;

/**
 * Created by fdkzv on 4/15/14.
 */
public class XMLMani {

    private static final Logger logger = LogManager.getLogger(XMLMani.class);

    public void modifyByXpath(String xpath, String value, Document doc){
        XPathFactory xPathFactory = XPathFactory.instance();
        XPathExpression expression = xPathFactory.compile(xpath, Filters.element());
        Element e = (Element) expression.evaluateFirst(doc);
        e.setText(value);
    }

    public void updateXML(Map<String,String> dataMap, Document doc){
        for(Map.Entry<String,String> entry:dataMap.entrySet()){
            modifyByXpath(entry.getKey(),entry.getValue(),doc);
        }
    }

    public void cloneNode(Document doc, String xpath, String childNode, int times){
        XPathFactory xPathFactory = XPathFactory.instance();
        XPathExpression expression = xPathFactory.compile(xpath, Filters.element());
        Element e = (Element) expression.evaluateFirst(doc);
        while (times != 1){
            System.out.println("created new node");
            e.addContent(e.getChild(childNode).clone());
            times--;
        }
        logger.debug("after cloning->" + new XMLOutputter().outputString(doc));

    }
}
