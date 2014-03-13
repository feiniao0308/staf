package com.bn.automation.scripts;

import org.openqa.selenium.By;

import com.bn.automation.staf.core.STAFDriver;
import com.bn.automation.staf.helpers.STAFConstant;

public class PopulateModalWindow {

	public static void main(String[] args) throws Throwable {
		STAFDriver driver = STAFDriver.getInstance(STAFConstant.FIREFOX);
		driver.get("http://qwecweb01.hq.bn-corp.com/bn/");
		driver.setTestCaseID("111");
		driver.setDataFileLocation("\\src\\test\\resources\\data\\xmlDataFormat.xml");
		driver.findElement(By.id("signInLink")).click();
		Thread.sleep(1000L);
		driver.findElement(By.id("createAccountBtn")).click();
		Thread.sleep(1000L);
		SO2 so = new SO2();
		driver.autopopulate("login", so);
		// driver.findElement(By.id("email")).sendKeys("karthi");

	}

}
