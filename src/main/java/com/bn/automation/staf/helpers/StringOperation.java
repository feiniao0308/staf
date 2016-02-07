package com.bn.automation.staf.helpers;

public class StringOperation {
	
	public String[] splitWithEqual(String value){
		return value.split("=");
	}


    public String[] splitHashTag(String value){
        return value.split("#",2);
    }



}
