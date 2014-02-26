package com.bn.automation.staf.core;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bn.automation.staf.anno.STAFScript;
import com.bn.automation.staf.helpers.STAFConstant;
import com.bn.automation.staf.util.STAFConfig;

public class STAFRunner extends IScript{
	
	private static final Logger logger = LogManager.getLogger(STAFRunner.class);
	private static Set<Class<?>> STAFScript = new HashSet<Class<?>>();
	private static Set<Class<?>> STAFSuite = new HashSet<Class<?>>();
	
	
	public static void main(String[] runnerArgs) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		validateScriptName(runnerArgs);
		validateConfigEnv();
		if(isGridMode()){
			System.out.println("******************GRID MODE*****************");
		} else{
			System.out.println("******************LOCAL MODE*****************");
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*//System.out.println(args[0]);
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
		}*/
		
	}
	
	private static void validateScriptName(String[] scripts){
		if(scripts.length == 0){
			logger.info("Pass script/suite to STAFRunner to execute");
			logger.error("Script execution process will be killed");
			System.exit(0);
		} else {
			logger.debug("Setting the environment for staf script/suite execution");
			setEnv();
			createClassMap(scripts);
		}
	}
	
	private static void createClassMap(String[] scripts) {
		for(String script:scripts){
			if(isStafScript())
		}
	}
	
	private static boolean isStafScript(Class<?> clazz){
		if(clazz.getAnnotation(STAFScript.class) != null){
			logger.debug(clazz.getCanonicalName() + " is identified as STAFScript");
			return true;
		} else {
			logger.trace(clazz.getCanonicalName() + "is identified as non-STAFScript");
			return false;
		}
		
		
	}

	private static void validateConfigEnv(){
		if(!info.containsKey(STAFConstant.CONFIG_KEY)){
			logger.info("Config file needs to be passed for staf script/suite execution");
			logger.error("Script execution process will be killed");
			System.exit(0);
		} else {
			logger.debug("Config file location is set as : " + info.get(STAFConstant.CONFIG_KEY));
			setConfigEnv();
		}
	}
	
	private static void setConfigEnv() {
		try {
			
			STAFConfig stafConfig = new STAFConfig();
			putInfoMap(STAFConstant.BROWSER_NAME_KEY, stafConfig.getField(STAFConstant.DEFAULT_BROWSER_NAME));
			putInfoMap(STAFConstant.URL_KEY, stafConfig.getField(STAFConstant.DEFAULT_URL));
			putInfoMap(STAFConstant.IE_DRIVER_PATH_KEY, stafConfig.getField(STAFConstant.IE_DRIVER_PATH));
			putInfoMap(STAFConstant.CHROME_DRIVER_PATH_KEY, stafConfig.getField(STAFConstant.CHROME_DRIVER_PATH));
			putInfoMap(STAFConstant.KILL_BROWSER_AFTER_TEST_KEY, stafConfig.getField(STAFConstant.KILL_BROWSER_AFTER_TEST));
			putInfoMap(STAFConstant.KILL_DRIVER_AFTER_TEST_KEY, stafConfig.getField(STAFConstant.KILL_DRIVER_AFTER_TEST));
			putInfoMap(STAFConstant.GRID_KEY, stafConfig.getField(STAFConstant.GRID));
			
					
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}

	private static boolean isGridMode(){
		if((boolean) info.get(STAFConstant.GRID_KEY)){
			logger.info("grid execution is set to true");
			logger.info("STAF GRID EXECUTION STARTS NOW");
			viewInfoMap();
			return true;
			
		} else {
			logger.info("local execution is set to true");
			logger.info("STAF LOCAL EXECUTION STARTS NOW");
			viewInfoMap();
			return false;
		}
		
	}
	
	

}
