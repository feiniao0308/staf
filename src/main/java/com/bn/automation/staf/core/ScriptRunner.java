package com.bn.automation.staf.core;

import java.lang.reflect.Method;

import com.bn.automation.staf.anno.Test;

class ScriptRunner {

	public void initiateScript(Class<?> clazz) {
		System.out.println(clazz.getCanonicalName());
		System.out.println("**************INITIALIZING SCRIPT***************");
		Object obz = null;
		try {
			obz = clazz.newInstance();
			Method[] methods = clazz.getDeclaredMethods();

			for (Method method : methods) {
				if (method.getAnnotation(Test.class) != null) {
					try {
						System.out.println("****************INVOKING TEST METHOD****************");
						method.invoke(obz);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
		}

		

	}

	private void invokeTestMethod() {

	}

}
