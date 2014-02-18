package com.bn.automation.staf.core;

import java.lang.reflect.Method;

import com.bn.automation.scripts.AnnoScript;

public class STAFRunner {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		
		//System.out.println(args[0]);
		//Class className = Class.forName("AnnoScript");
		
		//Object annoObj = className.newInstance();
		Class clazz = Class.forName("com.bn.automation.scripts.AnnoScript");
		Object obz = clazz.newInstance();
		
		Method[] methods = clazz.getDeclaredMethods();
		//AnnoScript script = new AnnoScript();
		//Method[] methods = script.getClass().getDeclaredMethods();
		
		for(Method method:methods){
			if(method.getAnnotation(Test.class) != null){
				try{
					method.invoke(obz);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
