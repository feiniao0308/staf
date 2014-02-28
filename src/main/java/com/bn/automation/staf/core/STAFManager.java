package com.bn.automation.staf.core;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.bn.automation.staf.helpers.STAFConstant;

public class STAFManager {
	
	private static STAFManager manager = null;
	private static final Pointer HEAD = new Pointer();
	

	private static final Pointer TAIL = new Pointer();
	private static STAFDriver stafInstance = null;
	private static Map<Pointer,WebDriver> wd = new HashMap<Pointer,WebDriver>();
	
	
	
	private static Map<Pointer,STAFDriver> headPointer = new HashMap<Pointer,STAFDriver>();
	private static Map<STAFDriver,WebDriver> tailPointer = new HashMap<STAFDriver,WebDriver>();

	public STAFManager() {
		//createStafInstance();
	}

	public static STAFManager getInstance(STAFDriver sd, WebDriver wd){
		System.out.println("SD:" + sd);
		System.out.println("WD:" + wd);
		if(manager == null){
			manager =  new STAFManager();
			System.out.println("created new stafmanager");
			
			/*wd.put(HEAD, d);
			wd.put(TAIL, null);*/
		}
		putHeadPointer(sd);
		putTailPointer(sd, wd);
		System.out.println("returning stafmanager");
		return manager;
	}
	
	@Deprecated
	public static STAFManager getInstance(WebDriver d){
		if(manager == null){
			manager =  new STAFManager();
			System.out.println("created new stafmanager");
			/*wd.put(HEAD, d);
			wd.put(TAIL, null);*/
		}
		System.out.println("returning stafmanager");
		return manager;
	}
	
	public static Map<Pointer, STAFDriver> getHeadPointer() {
		return headPointer;
	}


	public static void putHeadPointer(STAFDriver sd) {
		getHeadPointer().put(HEAD, sd);
	}


	public static Map<STAFDriver, WebDriver> getTailPointer() {
		return tailPointer;
	}


	public static void putTailPointer(STAFDriver sd, WebDriver wd) {
		getTailPointer().put(sd, wd);
	}


	public static Pointer getHead() {
		return HEAD;
	}
	
	
	public static Map<Pointer, WebDriver> getWd() {
		return wd;
	}


	public static void setWd(HashMap<Pointer, WebDriver> wd) {
		STAFManager.wd = wd;
	}

	private void insertPointer(Pointer p, WebDriver d){
		wd.put(p, d);
	}
	
	public void viewPointers(){
		for(Map.Entry<Pointer, WebDriver> pointer : wd.entrySet()){
			System.out.println("Pointer is->" + pointer.getKey());
			System.out.println("WebDriver is->" + pointer.getValue());
		}
	}
	private void setAsPointerHead(WebDriver d){
		//for()
	}
	
	
	
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
	
	public STAFDriver getInstance(){
		return stafInstance;
	}

}
