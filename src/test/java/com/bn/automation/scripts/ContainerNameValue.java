package com.bn.automation.scripts;

import com.bn.automation.staf.core.STAFDriver;
import com.bn.automation.staf.helpers.STAFConstant;

public class ContainerNameValue {

	public static void main(String[] args) throws Throwable {
		STAFDriver driver = STAFDriver.getInstance(STAFConstant.FIREFOX);
		SO2 so = new SO2();
		driver.get("http://www.iupui.edu/~webtrain/tutorials/forms_sample.html");
		driver.setTestCaseID("125");
		driver.setDataFileLocation("\\src\\test\\resources\\data\\xmlDataFormat.xml");
		Thread.sleep(5000L);
		driver.autopopulate("inputform", so);
	}

}
