package com.bn.automation.scripts;

import com.bn.automation.staf.anno.AfterMethod;
import com.bn.automation.staf.anno.BeforeMethod;
import com.bn.automation.staf.anno.STAFScript;
import com.bn.automation.staf.anno.Test;
import com.bn.automation.staf.http.RestManager;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by fdkzv on 3/31/14.
 */
@STAFScript
public class http2 {


        public RestManager restManager;
        public URI uri;


        @BeforeMethod
        public void setup() {
            restManager = new RestManager();
            restManager.connect();

            try {
                uri = new URIBuilder().setScheme("http").setHost("qwecweb01:80").setPath("/rest/model/atg/userprofiling/BNUserProfile/create/").build();
                restManager.setUri(uri);

            } catch (URISyntaxException e) {
                e.printStackTrace();
            }



        }

        @AfterMethod
        public void tearDown() {

            restManager.close();
        }

        @Test(id = {2,3}, enabled = true)
        public void keywordDrivenTest() throws Throwable {
            restManager.setData("data/xmlDataFormat.xml");

            restManager.setParameterPost("gender","female");

            restManager.doPost(uri, restManager.getData().getDataContainer("parameters"));
            restManager.autoAssert(restManager.getData().getDataContainer("assertResponse"));




        }




}
