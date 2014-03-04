package com.bn.automation.staf.core;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bn.automation.staf.anno.Test;
import com.bn.automation.staf.helpers.STAFConstant;

class ScriptRunner {
	
	private static final Logger logger = LogManager.getLogger(ScriptRunner.class);

	public void initiateScript(Class<?> clazz) {
		System.out.println(clazz.getCanonicalName());
		System.out.println("**************INITIALIZING SCRIPT***************");
		Object obz = null;
		try {
			obz = clazz.newInstance();
						
			invokeTestMethod(obz);
			

			/*for (Method method : methods) {
				if (method.getAnnotation(Test.class) != null) {
					try {
						System.out.println("****************INVOKING TEST METHOD****************");
						method.invoke(obz);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}*/
		} catch (InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
		}

		

	}
	
	private List<Method> getTestMethods(Object o){
		List<Method> testMethods = new LinkedList<Method>();
		Method[] methods = o.getClass().getDeclaredMethods();
		for (Method method : methods) {
			if (method.getAnnotation(Test.class) != null) {
				try {
					testMethods.add(method);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		logger.info("Number of test methods in class : " + o.getClass().getCanonicalName() + " is " + testMethods.size());
		return testMethods;
		
	}

	private void invokeTestMethod(Object obz) {
		
		for (Method method : getTestMethods(obz)) {
			if (method.getAnnotation(Test.class) != null) {
				try {
					logger.info(STAFConstant.DASH);
					logger.info("TEST METHOD : " + method.getName());
					logger.info(STAFConstant.DASH);
					method.invoke(obz);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

}
