package com.bn.automation.scripts;

import org.openqa.selenium.By;

import com.bn.automation.scripts.SO.SOinner;
import com.bn.automation.staf.core.STAFDriver;
import com.bn.automation.staf.helpers.STAFConstant;

public class TestBy {
	
	public static void main(String[] args) throws Throwable {
		
		
		/*STAFDriver d1 = new STAFDriver(STAFConstant.FIREFOX);
		STAFDriver d2 = new STAFDriver(STAFConstant.FIREFOX);
		
		
		
		d1.get("http://google.com");
		
		d2.get("http://google.com");
		
		Thread.sleep(5000);
		SOinner.q.sendKeys("hello");*/
		STAFDriver driver = STAFDriver.getInstance(STAFConstant.FIREFOX);
		
		driver.get("http://qwecweb01.hq.bn-corp.com/bn/");
		driver.setTestCaseID("111");
		driver.setDataFileLocation("\\src\\test\\resources\\data\\xmlDataFormat.xml");
		driver.findElement(By.id("signInLink")).click();
		Thread.sleep(1000L);
		driver.findElement(By.id("createAccountBtn")).click();
		Thread.sleep(1000L);
		SO so = new SO();
		driver.autopopulate("login", so);
		System.out.println(SOinner.fnameLabel.getText());
		// driver.findElement(By.id("email")).sendKeys("karthi");

	}

}
