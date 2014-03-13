package com.bn.automation.staf.util;

import org.jdom2.Element;

import java.util.HashMap;
import java.util.Map;

public interface IDataContainer {

    Element geteDataContainer();

    void seteDataContainer(Element eDataContainer);

    String getField(String fieldName);

    IDataContainer getDataContainer(String containerName);

    Map<String, String> get();


}
