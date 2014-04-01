package com.bn.automation.staf.http;

import com.bn.automation.staf.util.IDataContainer;
import com.bn.automation.staf.util.XML;

import java.net.URI;

/**
 * Created by fdkzv on 3/28/14.
 */
public interface WSDriver{

    public void connect();

    public void doPost(URI uri);

    public void doPost(URI uri,IDataContainer parameters);

    public void doPost(IDataContainer parameters);

    public void setParameters(RestDriver driver, IDataContainer parameters);

    public void setParmameters(String key, String value);

    public void setData(String dataPath);

    public XML getData();

    public void close();

    public void autoAssert(IDataContainer containerName);

}