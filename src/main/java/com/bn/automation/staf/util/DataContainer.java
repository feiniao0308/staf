package com.bn.automation.staf.util;

import com.bn.automation.staf.helpers.XMLConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom2.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataContainer implements IDataContainer {

    private static final Logger logger = LogManager.getLogger(DataContainer.class);
    private Element eDataContainer;

    @Override
    public Element geteDataContainer() {
        return eDataContainer;
    }

    @Override
    public void seteDataContainer(Element eDataContainer) {
        this.eDataContainer = eDataContainer;
    }

    @Override
    public String getField(String fieldName) {
        String value = null;
        List<Element> fieldNodes = this.geteDataContainer().getChildren(XMLConstant.FIELD);
        for (Element fieldNode : fieldNodes) {
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

    @Override
    public IDataContainer getDataContainer(String containerName) {

        IDataContainer container = new DataContainer();
        List<Element> containerNodes = this.eDataContainer.getChildren(XMLConstant.DATACONTAINER);
        for (Element containerNode : containerNodes) {
            logger.trace("XML : DataContainer name->"
                    + containerNode.getAttributeValue(XMLConstant.NAME)
                    + " | value->"
                    + containerNode.getAttributeValue(XMLConstant.VALUE));

            if (containerNode.getAttributeValue(XMLConstant.NAME).equals(containerName)) {
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
    public Map<String, String> get() {
        Map<String, String> dataMap = new HashMap<String, String>();
        List<Element> fieldNodes = this.eDataContainer.getChildren(XMLConstant.FIELD);
        for (Element fieldNode : fieldNodes) {
            logger.trace("XML : Field name->"
                    + fieldNode.getAttributeValue(XMLConstant.NAME)
                    + " | value->"
                    + fieldNode.getAttributeValue(XMLConstant.VALUE));
            dataMap.put(fieldNode.getAttributeValue(XMLConstant.NAME), fieldNode.getAttributeValue(XMLConstant.VALUE));
        }

        return logger.exit(dataMap);
    }


}
