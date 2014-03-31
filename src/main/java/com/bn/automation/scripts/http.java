package com.bn.automation.scripts;

import com.bn.automation.staf.anno.AfterMethod;
import com.bn.automation.staf.anno.BeforeMethod;
import com.bn.automation.staf.anno.STAFScript;
import com.bn.automation.staf.anno.Test;
import com.bn.automation.staf.http.RestManager;
import com.bn.automation.staf.util.Json;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Created by fdkzv on 3/27/14.
 */
@STAFScript
public class http {

    public RestManager restManager;


    @BeforeMethod
    public void setup() {
        restManager = new RestManager();
        restManager.connect();
        URI uri;
        try {
            uri = new URIBuilder().setScheme("http").setHost("qwecweb01:80").setPath("/rest/model/atg/userprofiling/BNUserProfile/create/").build();
            restManager.doPost(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }



    }

    @AfterMethod
    public void tearDown() {

       restManager.close();
    }

    @Test(id = {1}, enabled = true)
    public void keywordDrivenTest() throws Throwable {

        try{
            ArrayList<NameValuePair> nvp = new ArrayList<NameValuePair>(1);
            nvp.add(new BasicNameValuePair("lastModified", ""));
            nvp.add(new BasicNameValuePair("mercuryUserId", ""));
            nvp.add(new BasicNameValuePair("displayNumber", ""));
            nvp.add(new BasicNameValuePair("creditCardType", ""));
            nvp.add(new BasicNameValuePair("creditCardExpMo", ""));
            nvp.add(new BasicNameValuePair("creditCardExpYr", ""));
            nvp.add(new BasicNameValuePair("mercuryCardId", ""));
            restManager.getHttpPost().setEntity(new UrlEncodedFormEntity(nvp, Consts.UTF_8));
            HttpResponse httpResponse = restManager.getResponse(restManager.getHttpPost());

            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = restManager.getHttpclient().execute(restManager.getHttpPost(), responseHandler);
            //Assert.assertTrue(responseBody.contains("\"localizedMessage\": \"Login is required field\""));


            System.out.println("----------------------------------------");
            System.out.println("\n");
            System.out.println("Length:" + responseBody.length());
            System.out.println("\n");

            System.out.println("Contents: " + "\n" + responseBody);

            BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }

            JSONObject jsonObject2 = new JSONObject(httpResponse);
            System.out.println("jsonObject2 = " + jsonObject2);
            JSONObject jsonObject = new JSONObject(responseBody);
            Json json = new Json(jsonObject);
            System.out.println("json.get() = " + json.get("formExceptions[0].localizedMessage"));
            System.out.println("json.get(\"formError\") = " + json.get("formError"));

            //System.out.println("XML.toString(jsonObject) = " + XML.toString(jsonObject));
            //String xml2 = XML.toString(jsonObject);

            /*XML xml = new XMLDocument("<orders><order id=\"4\">Coffee to go</order></orders>");
            String id = xml.xpath("//order/@id").get(0);
            String name = xml.xpath("//order[@id=4]/text()").toString();
            System.out.println(xml.toString());
            System.out.println("name = " + name);
            System.out.println("id = " + id);

            XML xml2 = new XMLDocument(org.json.XML.toString(jsonObject));
            String formError = xml2.xpath("//formError").get(0);
            System.out.println("formError = " + formError);*/



           /* XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();

            InputSource source = new InputSource(new StringReader(xml));
            Document document = (Document) xpath.evaluate("/", source, XPathConstants.NODE);
            String msg = xpath.evaluate("/formError", document);
            String status = xpath.evaluate("/formExceptions/localizedMessage", document);

            System.out.println("status=" + status);
            System.out.println("Message=" + msg);*/

           // JsonPath jsonPath = new JsonPath();

           // String value = JsonPath.read(responseBody,"$.formError");
          //  System.out.println(JsonPath.read(new InputStreamReader(httpResponse.getEntity().getContent()), "$.formExceptions[0].localizedMessage"));
           /* System.out.println("value = " + value);
            Object one = JsonPath.parse(new InputStreamReader(httpResponse.getEntity().getContent()));
            System.out.println("one = " + one);
            String value2 = JsonPath.read(one,"$.formError");
            System.out.println("value2 = " + value2);*/


            /*for (int i=0; i < jArray.length(); i++)
            {
                JSONObject oneObject = jArray.getJSONObject(i);
                // Pulling items from the array

                System.out.println("oneObject.getString(\"localizedMessage\") = " + oneObject.getString("localizedMessage"));
                //your rest code here...
            }*/
            


        } catch (IOException e){
            e.printStackTrace();
        }


    }


}
