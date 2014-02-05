package com.bn.automation.scripts;

import com.bn.automation.staf.core.STAFDriver;
import com.bn.automation.staf.helpers.STAFConstant;

public class BaseScript2 {

	public static void main(String[] args) {
		System.out.println("hello from basescript");
		STAFDriver driver = STAFDriver.getInstance(STAFConstant.HTML_UNIT);

		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.quit();
	}

}
