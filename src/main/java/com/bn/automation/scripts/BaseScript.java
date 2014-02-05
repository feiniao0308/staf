package com.bn.automation.scripts;

import com.bn.automation.staf.core.STAFDriver;
import com.bn.automation.staf.helpers.STAFConstant;

public class BaseScript {

	public static void main(String[] args) {
		System.out.println("hello from basescript");
		String browser = String.valueOf(System.getProperty("browser"));
		String b = System.getProperty("b");
	//	System.out.println("b: " + b);

		//System.out.println("Browser : " + browser);
		STAFDriver driver = STAFDriver.getInstance(STAFConstant.FIREFOX);

		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.quit();
	}

}
