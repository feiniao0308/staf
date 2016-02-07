package com.bn.automation.staf.http;

import com.bn.automation.staf.util.IDataContainer;
import com.bn.automation.staf.util.XML;

import java.net.URI;
import java.util.Map;

/**
 * Created by fdkzv on 3/28/14.
 */
public interface WSDriver{

    void connect();

    void doPost(URI uri);

    void doPost(URI uri,IDataContainer parameters);

    void doPost(IDataContainer parameters);

    void doPostWithXml(URI uri, String xmlPath, IDataContainer parameters);

    void doPostWithXml(URI uri, String xmlPath, Map<String, String> parameters);

    void doPostWithXml(URI uri, String xmlPath);

    void setParameters(RestDriver driver, IDataContainer parameters);

    void setParmameters(String key, String value);

    void setParameterPost(String key, String value);

    void setData(String dataPath);

    XML getData();

    void close();

    void autoAssert(IDataContainer containerName);

    void setUri(URI uri);
}