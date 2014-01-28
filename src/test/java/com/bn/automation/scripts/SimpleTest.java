package com.bn.automation.scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bn.automation.staf.core.STAFDriver;
import com.bn.automation.staf.helpers.STAFConstant;

public class SimpleTest {

	private static STAFDriver driver;

	@BeforeMethod
	public void setup() {
		driver = STAFDriver.getInstance(STAFConstant.HTML_UNIT);
		driver.get("http://qwecweb01.hq.bn-corp.com/bn/");
	}

	public void tearDown() {
		driver.quit();
	}

	@Test
	public void test() {

		Assert.assertTrue(driver.getTitle().equals("B&N | Homepage"));
	}

}
