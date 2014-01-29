package com.bn.automation.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bn.automation.staf.core.STAFDriver;
import com.bn.automation.staf.helpers.STAFConstant;

public class SimpleTest {

	private static STAFDriver driver;

	@BeforeMethod
	public void setup() {
		driver = STAFDriver.getInstance(STAFConstant.FIREFOX);
		driver.get("http://google.com");
	}

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

	@Test
	public void test() throws Throwable {

		
		/*SO so = new SO();
		so.searchbar.autoPopulate();
		SO.searchbar.autoPopulate();
		new XMLReader().getContainer();
		//Assert.assertTrue(driver.getTitle().equals("B&N | Homepage"));
*/	}

}
