package com.bn.automation.staf.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by fdkzv on 3/28/14.
 */
public class Json implements IJson {

    private JSONObject jsonObject;

    public Json(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    @Override
    public String get(String jsonPath) {
        System.out.println("jsonPath = " + jsonPath);
        String[] jpath = jsonPath.split("\\.");
        System.out.println("jpath = " + jpath.toString());
        for (String j : jpath) {
            System.out.println("j = " + j);
        }
        JSONObject jobj = this.getJsonObject();
        String value = null;
        try {
            String jp;
            for (int i = 0; i < jpath.length; i++) {
                jp = jpath[i];
                System.out.println("jp = " + jp);
                if (i == jpath.length - 1) {
                    value = jobj.get(jp).toString();
                    System.out.println("value = " + value);
                    break;
                }
                if (jp.contains("[") && jp.contains("]")) {
                    int begin = jp.length() - 2;
                    int end = jp.length() - 1;
                    System.out.println("begin = " + begin);
                    System.out.println("end = " + end);
                    int index = Integer.valueOf(jp.substring(begin, end));
                    String arrayName = jp.substring(0, jp.length() - 3);
                    System.out.println("index = " + index);
                    System.out.println("arrayName = " + arrayName);
                    JSONArray jsonArray = jobj.getJSONArray(arrayName);
                    jobj = (JSONObject) jsonArray.get(index);
                    System.out.println("jobj = " + jobj);
                } else {
                    jobj = (JSONObject) jobj.get(jp);
                    System.out.println("jobj = " + jobj);
                }

            }


            value = jobj.getString(jpath[jpath.length - 1]);
            //return value;


            //value = this.getJsonObject().getString(jsonPath);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return value;
    }
}
