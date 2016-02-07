package com.bn.automation.staf.db;

import com.bn.automation.staf.util.IDataContainer;
import com.bn.automation.staf.util.XML;

/**
 * Created by fdkzv on 4/1/14.
 */
public interface DBDriver {


    void connect(String hostname, String port, String serviceName, String username, String password);

    void doQuery(String sql);

    void autoAssert(IDataContainer containerName);

    void viewQueryResult(String sql);

    void setData(String dataPath);

    XML getData();

}
