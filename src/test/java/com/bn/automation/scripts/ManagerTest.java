package com.bn.automation.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.bn.automation.staf.core.STAFDriver;
import com.bn.automation.staf.core.STAFManager;
import com.bn.automation.staf.helpers.STAFConstant;

public class ManagerTest {

	public static void main(String[] args) {
		
		STAFDriver d1 = new STAFDriver(STAFConstant.FIREFOX);
		STAFDriver d2 = new STAFDriver(STAFConstant.FIREFOX);
		
		System.out.println("head pointer :" + STAFManager.getHeadPointer());
		System.out.println("tail pointer : " + STAFManager.getTailPointer());
		
		
		d1.setAsHead();
		
		System.out.println("--------------");
		System.out.println("head pointer :" + STAFManager.getHeadPointer());
		System.out.println("tail pointer : " + STAFManager.getTailPointer());
		
		System.out.println("The End");
		
		//STAFManager sm2 = data STAFManager();
	}
}
