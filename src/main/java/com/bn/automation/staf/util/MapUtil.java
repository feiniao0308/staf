package com.bn.automation.staf.util;

import java.util.Map;

/**
 * Created by fdkzv on 4/16/14.
 */
public class MapUtil {

    public void printMap(Map<?,?> map){
        for(Map.Entry entry:map.entrySet()){
            System.out.println("Key->" + entry.getKey().toString() + " | Value->" + entry.getValue().toString());
        }

    }

    public void printMap(Map<?,?> map, String msg){
        for(Map.Entry entry:map.entrySet()){
            System.out.println(msg + " => Key->" + entry.getKey().toString() + " | Value->" + entry.getValue().toString());
        }

    }
}
