package com.bn.automation.staf.helpers;

import com.bn.automation.staf.util.Json;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;


/**
 * Created by fdkzv on 3/31/14.
 */
public class Assert {

    private static final Logger logger = LogManager.getLogger();

    public void assertMap(Map<String,String> dataMap, Json responseJson){
        String responseBody = responseJson.toString();
        logger.trace(responseBody);

        for(Map.Entry<String,String> entry :dataMap.entrySet()){
            logger.trace("Data map key->" + entry.getKey());
            logger.trace("Data map value->" + entry.getValue());

            new Verify().assertEquals(responseJson.get(entry.getKey()),entry.getValue(), " | Assert: " + entry.getKey() + "->"+entry.getValue() );
        }


    }
}
