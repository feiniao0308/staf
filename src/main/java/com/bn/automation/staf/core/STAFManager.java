package com.bn.automation.staf.core;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.bn.automation.staf.helpers.STAFConstant;

public class STAFManager {

	private static STAFManager manager = null;
	private static final Pointer HEAD = new Pointer();
	private static Map<Pointer, STAFDriver> headPointer = new HashMap<Pointer, STAFDriver>();
	private static Map<STAFDriver, WebDriver> tailPointer = new HashMap<STAFDriver, WebDriver>();
	// private static final Pointer TAIL = data Pointer();
	@Deprecated
	private static STAFDriver stafInstance = null;
	private static final Logger logger = LogManager
			.getLogger(STAFManager.class);
	

	public STAFManager() {
		logger.entry();
		logger.debug("STAFManager is Singleton Class");
		logger.debug("Use STAFManager.getInstance(STAFDriver sd, WebDriver wd) method to instantiate data STAFManager object. ");
	}

	public static STAFManager getInstance(STAFDriver sd, WebDriver wd) {
		logger.entry(sd, wd);
		logger.debug("STAFManager instance is created using STAFDriver instance->"
				+ sd + " and WebDriver instance->" + wd);
		if (manager == null) {
			manager = new STAFManager();
			logger.debug("STAFManager was null and hence data singleton object is been created");
		}
		putHeadPointer(sd);
		putTailPointer(sd, wd);
		logger.debug("Head Pointer and Tail Pointer is been mapped with STAFDriver and WebDriver instances");
		return logger.exit(manager);
	}

	

	public static Map<Pointer, STAFDriver> getHeadPointer() {
		logger.entry();
		return logger.exit(headPointer);
	}

    public static STAFDriver getHeadSD(){
        return getHeadPointer().get(getHead());
    }

	public static void putHeadPointer(STAFDriver sd) {
		logger.entry(sd);
		logger.debug("STAFDriver instance->" + sd + " is set as HEAD Pointer");
		logger.warn("WARNING : All STAFElement actions will be made on this instance only");
		getHeadPointer().put(getHead(), sd);
	}

	public static Map<STAFDriver, WebDriver> getTailPointer() {
		logger.entry();
		return logger.exit(tailPointer);
	}

	public static void putTailPointer(STAFDriver sd, WebDriver wd) {
		logger.entry(sd, wd);
		logger.debug("STAFDriver instance->" + sd
				+ "<-key and WebDriver instance->" + wd
				+ "<-value is been set in Tail Pointer");
		logger.warn("WARNING : All STAFElement actions will not be made on this instance if it's HEAD pointer is not set to correct STAFDriver instance");
		getTailPointer().put(sd, wd);
	}

	public static Pointer getHead() {
		return HEAD;
	}

	

	public void viewHeadPointer() {
		for (Map.Entry<Pointer, STAFDriver> headPointer : getHeadPointer().entrySet()) {
			logger.debug("KEY : Pointer ->" + headPointer.getKey() + " & VALUE : STAFDriver->" + headPointer.getValue());
		}
	}
	
	public void viewTailPointers(){
		for (Map.Entry<STAFDriver,WebDriver> tailPointer : getTailPointer().entrySet()) {
			logger.debug("KEY : STAFDriver->" + tailPointer.getKey() + " & VALUE : WebDriver->" + tailPointer.getValue());
		}
	}

	//Deprecated methods
	//TODO remove these methods
	
	@Deprecated
	protected void createStafInstance() {

		if (stafInstance != null)
			return;
		try {
			if (stafInstance == null) {
				stafInstance = STAFDriver.getInstance(STAFConstant.FIREFOX);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Deprecated
	public STAFDriver getInstance() {
		return stafInstance;
	}
	
	@Deprecated
	public static STAFManager getInstance(WebDriver d) {
		if (manager == null) {
			manager = new STAFManager();
			System.out.println("created data stafmanager");
			/*
			 * wd.put(HEAD, d); wd.put(TAIL, null);
			 */
		}
		System.out.println("returning stafmanager");
		return manager;
	}

}
