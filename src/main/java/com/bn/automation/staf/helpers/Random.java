package com.bn.automation.staf.helpers;

import java.util.UUID;

/**
 * Created by fdkzv on 3/31/14.
 */
public class Random {

    public int getRandomNum(){
        return new java.util.Random().nextInt(100000000);
    }

    public String getRandomString(){
        return UUID.randomUUID().toString().substring(24);
    }

    public String getRandomEmail(){
        return "test"+UUID.randomUUID().toString().substring(24)+"@bn.com";

    }
}
