package com.bn.automation.staf.util;

import com.bn.automation.staf.core.STAFRunner;
import com.bn.automation.staf.helpers.XMLConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom2.Element;

import java.util.List;

public class XML implements IXML {

    private static final Logger logger = LogManager.getLogger(XML.class);


    @Override
    public IDataContainer getDataContainer(String containerName) {

        return getDataContainer(containerName, Integer.toString(STAFRunner.getTestID()));
    }

    private IDataContainer getDataContainer(String containerName, String testID) {
        IDataContainer container = new DataContainer();
        Element rootNode = STAFRunner.getXmlMap().get(this).getRootElement();

        List<Element> containerNodes = rootNode.getChildren(XMLConstant.DATACONTAINER);
        for (Element containerNode : containerNodes) {
            //System.out.println(fieldNode);
            logger.trace("XML : DataContainer name->"
                    + containerNode.getAttributeValue(XMLConstant.NAME)
                    + " | value->"
                    + containerNode.getAttributeValue(XMLConstant.VALUE));

            if ((containerNode.getAttributeValue(XMLConstant.NAME).equals(containerName)) && (containerNode.getAttributeValue(XMLConstant.VALUE).equals(testID))) {
                logger.debug("XML : DataContainer name->"
                        + containerNode.getAttributeValue(XMLConstant.NAME)
                        + " | value->"
                        + containerNode.getAttributeValue(XMLConstant.VALUE));
                container.seteDataContainer(containerNode);
                break;
            }

        }

        return logger.exit(container);
    }


    @Override
    public String getField(String fieldName) {
        String value = null;
        /*System.out.println("inside field");
        System.out.println("this = " + this);
        System.out.println("STAFRunner.getXmlMap().get(this) = " + STAFRunner.getXmlMap().get(this));
        System.out.println(STAFRunner.getXmlMap().get(this).getRootElement()
                .getAttributes());*/
        Element rootNode = STAFRunner.getXmlMap().get(this).getRootElement();

        List<Element> fieldNodes = rootNode.getChildren(XMLConstant.FIELD);
        for (Element fieldNode : fieldNodes) {
            //System.out.println(fieldNode);
            logger.trace("XML : Field name->"
                    + fieldNode.getAttributeValue(XMLConstant.NAME)
                    + " | value->"
                    + fieldNode.getAttributeValue(XMLConstant.VALUE));

            if (fieldNode.getAttributeValue(XMLConstant.NAME).equals(fieldName)) {
                logger.debug("XML : Field name->"
                        + fieldNode.getAttributeValue(XMLConstant.NAME)
                        + " | value->"
                        + fieldNode.getAttributeValue(XMLConstant.VALUE));
                value = fieldNode.getAttributeValue(XMLConstant.VALUE);
                break;
            }

        }
        return logger.exit(value);
    }


    public boolean isFieldPresent(String fieldName) {
        String fieldValue = null;
        boolean isFieldPresent;

        Element rootNode = STAFRunner.getXmlMap().get(this).getRootElement();
        List<Element> fieldNodes = rootNode.getChildren();

        for (Element fieldNode : fieldNodes) {
            logger.trace("field name and value in congif file is "
                    + fieldNode.getAttributeValue(XMLConstant.NAME) + "->"
                    + fieldNode.getAttributeValue(XMLConstant.VALUE));
            if (fieldNode.getAttributeValue(XMLConstant.NAME).equals(
                    fieldName)) {
                fieldValue = fieldNode
                        .getAttributeValue(XMLConstant.VALUE);
                logger.debug("field name->" + fieldName + " & value->"
                        + fieldValue);
            }
        }

        if (fieldValue == null) {
            logger.error("field name : " + fieldName + " is not found in xml file");
            isFieldPresent = false;
        } else {
            logger.error("field name : " + fieldName + " is found in xml file");
            isFieldPresent = true;
        }


        return logger.exit(isFieldPresent);
    }


}
