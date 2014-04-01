package com.bn.automation.staf.http;

import com.bn.automation.staf.core.STAFRunner;
import com.bn.automation.staf.helpers.Assert;
import com.bn.automation.staf.helpers.RESTConstant;
import com.bn.automation.staf.helpers.Random;
import com.bn.automation.staf.util.FileUtil;
import com.bn.automation.staf.util.IDataContainer;
import com.bn.automation.staf.util.Json;
import com.bn.automation.staf.util.XML;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by fdkzv on 4/1/14.
 */
public class RestDriver implements WSDriver {

    private HttpClient httpclient;



    private HttpResponse httpResponse;
    private HttpGet httpGet;
    private HttpPost httpPost;
    private String response;
    private URI uri;
    private int responseCode;
    private ArrayList<NameValuePair> parameterMap = new ArrayList<NameValuePair>(1);
    private static final Logger logger = LogManager.getLogger(RestManager.class);

    @Override
    public void connect() {
        logger.debug("Connecting HTTP Client ...");
        setHttpclient(HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build());
        logger.info("Connected with HTTP Client");

    }

    @Override
    public void doPost(URI uri) {
        if(this.getHttpPost() == null ){
            this.setHttpPost(new HttpPost(this.getUri()));
        }
        //setHttpPost(new HttpPost(uri));
        if(getHttpclient() != null && getHttpPost() != null){
            try {
                setHttpResponse(getHttpclient().execute(httpPost));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void doPost(URI uri, IDataContainer parameters) {
        if(this.getHttpPost() == null ){
            this.setHttpPost(new HttpPost(this.getUri()));
        }
        //setHttpPost(new HttpPost(uri));

        setParameters(this,parameters);
        this.getHttpPost().setEntity(new UrlEncodedFormEntity(this.getParameterMap(), Consts.UTF_8));

        if(getHttpclient() != null && getHttpPost() != null){
            try {
                this.setHttpResponse(getHttpclient().execute(this.getHttpPost()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.setResponseCode(this.getHttpResponse().getStatusLine().getStatusCode());
        if(this.getResponseCode() == HttpStatus.SC_OK){
            logger.info("Response OK , code->" + this.getResponseCode());
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            try {
                this.setResponse(responseHandler.handleResponse(this.getHttpResponse()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.info("Reponse body : \n" + this.getResponse());
        } else{
            logger.info("Response ERROR, code->" + this.getResponseCode());
            logger.info("Reponse body : \n" + this.getResponse());
        }

    }

    @Override
    public void doPost(IDataContainer parameters) {
        if(this.getHttpPost() == null ){
            this.setHttpPost(new HttpPost(this.getUri()));
        }
        //setHttpPost(new HttpPost(this.getUri()));

        setParameters(this,parameters);
        this.getHttpPost().setEntity(new UrlEncodedFormEntity(this.getParameterMap(), Consts.UTF_8));

        if(getHttpclient() != null && getHttpPost() != null){
            try {
                this.setHttpResponse(getHttpclient().execute(this.getHttpPost()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.setResponseCode(this.getHttpResponse().getStatusLine().getStatusCode());
        if(this.getResponseCode() == HttpStatus.SC_OK){
            logger.info("Response OK , code->" + this.getResponseCode());
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            try {
                this.setResponse(responseHandler.handleResponse(this.getHttpResponse()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.info("Reponse body : \n" + this.getResponse());
        } else{
            logger.info("Response ERROR, code->" + this.getResponseCode());
            logger.info("Reponse body : \n" + this.getResponse());
        }

    }

    @Override
    public void setParameters(RestDriver driver, IDataContainer parameters) {
        Map<String,String> paraMap = parameters.get();
        //ArrayList<NameValuePair> nvp = new ArrayList<NameValuePair>(1);
        for(Map.Entry<String,String> para : paraMap.entrySet()){
            //logger.info("Set Parameter key->" + para.getKey());

            switch(para.getValue()){
                case RESTConstant.RANDOM_NUMBER:
                    //System.out.println("random number");
                    int randomNumber = new Random().getRandomNum();
                    this.getParameterMap().add(new BasicNameValuePair(para.getKey(), String.valueOf(randomNumber)));
                    //nvp.add(new BasicNameValuePair(para.getKey(), String.valueOf(randomNumber)));
                    logger.info("Set Parameter: " + para.getKey() + "->" + randomNumber);
                    break;

                case RESTConstant.RANDOM_EMAIL:
                    //System.out.println("random email");
                    String randomEmail = new Random().getRandomEmail();
                    this.getParameterMap().add(new BasicNameValuePair(para.getKey(), randomEmail));
                    //nvp.add(new BasicNameValuePair(para.getKey(), randomEmail));
                    logger.info("Set Parameter: " + para.getKey() + "->" + randomEmail);
                    break;
                default:
                    //System.out.println("default");
                    logger.info("Set Parameter: " + para.getKey() + "->" + para.getValue());
                    this.getParameterMap().add(new BasicNameValuePair(para.getKey(), para.getValue()));
                    //nvp.add(new BasicNameValuePair(para.getKey(), para.getValue()));
                    //manager.getHttpPost().setEntity(new UrlEncodedFormEntity(nvp, Consts.UTF_8));
            }

            // nvp.add(new BasicNameValuePair(para.getKey(), para.getValue()));

        }
        //manager.getHttpPost().setEntity(new UrlEncodedFormEntity(this.getParameterMap(), Consts.UTF_8));
        logger.info("All Parameters SET");

    }

    @Override
    public void setParmameters(String key, String value) {
        if(this.getHttpPost() == null ){
            this.setHttpPost(new HttpPost(this.getUri()));
        }
        //ArrayList<NameValuePair> nvp = new ArrayList<NameValuePair>(1);
        this.getParameterMap().add(new BasicNameValuePair(key, value));
        //nvp.add(new BasicNameValuePair(key, value));
        logger.info("Set Parameter: " + key + "->" + value);
        //this.getHttpPost().setEntity(new UrlEncodedFormEntity(this.getParameterMap(), Consts.UTF_8));

    }

    @Override
    public void setData(String dataPath) {
        new FileUtil().createData(dataPath);

    }

    @Override
    public XML getData() {
        return STAFRunner.getDataXml();

    }

    @Override
    public void close() {
        this.getHttpPost().completed();
        logger.info("Connection Closed");

    }

    @Override
    public void autoAssert(IDataContainer containerName) {
        Map<String,String> dataMap = containerName.get();
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(this.getResponse());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Json json = new Json(jsonObject);
        new Assert().assertMap(dataMap,json);

    }

    public HttpResponse getResponse(HttpPost httpPost){

        if(getHttpclient() != null && getHttpPost() != null){
            try {
                setHttpResponse(getHttpclient().execute(httpPost));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return getHttpResponse();

    }

    public HttpResponse getResponse(HttpGet httpGet){
        if(getHttpclient() != null && getHttpGet() != null){
            try {
                setHttpResponse(getHttpclient().execute(httpGet));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return getHttpResponse();
    }

    public HttpClient getHttpclient() {
        return httpclient;
    }

    public void setHttpclient(HttpClient httpclient) {
        this.httpclient = httpclient;
    }

    public HttpResponse getHttpResponse() {
        return httpResponse;
    }

    public void setHttpResponse(HttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    public HttpGet getHttpGet() {
        return httpGet;
    }

    public void setHttpGet(HttpGet httpGet) {
        this.httpGet = httpGet;
    }

    public HttpPost getHttpPost() {
        return httpPost;
    }

    public void setHttpPost(HttpPost httpPost) {
        this.httpPost = httpPost;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public ArrayList<NameValuePair> getParameterMap() {
        return parameterMap;
    }

    public void setParameterMap(ArrayList<NameValuePair> parameterMap) {
        this.parameterMap = parameterMap;
    }
}
