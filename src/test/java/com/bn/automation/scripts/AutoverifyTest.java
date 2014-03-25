package com.bn.automation.scripts;

import com.bn.automation.staf.core.STAFDriver;
import com.bn.automation.staf.helpers.STAFConstant;

public class AutoverifyTest {

	public static void main(String[] args) throws Throwable {
		STAFDriver driver = STAFDriver.getInstance(STAFConstant.FIREFOX);
		driver.get("http://www.iupui.edu/~webtrain/tutorials/forms_sample.html");
		driver.setTestCaseID("145");
		driver.setDataFileLocation("\\src\\test\\resources\\data\\xmlDataFormat.xml");
		Thread.sleep(1000L);
		SO2 so = new SO2();
		driver.autoVerify(driver.getData().getDataContainer("verifyform"), so);
		
	}

}
