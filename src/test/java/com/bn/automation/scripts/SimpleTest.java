package com.bn.automation.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.bn.automation.staf.core.STAFDriver;
import com.bn.automation.staf.core.Test;

public class SimpleTest {

	private static STAFDriver driver;

	@BeforeMethod
	public void setup() {
		/*driver = STAFDriver.getInstance(STAFConstant.FIREFOX);
		driver.get("http://www.w3schools.com/html/html_forms.asp");*/
	}

	@AfterMethod
	public void tearDown() {
		
		//driver.quit();
	}

	@Test
	public void test() throws Throwable {
		
		System.out.println("hello from test method");
		/*System.out.println("hello");

		//driver.autopopulate("hello", this.getClass());
		driver.setDataFileLocation("\\src\\test\\resources\\data\\xmlDataFormat.xml");
		driver.autopopulate("inputform", SO.class);
		//System.out.println(Class.forName(""));
		//System.out.println("SO"+getField("searchbar"));
		SO so = new SO();
		so.searchbar.autoPopulate();
		SO.searchbar.autoPopulate();
		new XMLReader().getContainer();
		//Assert.assertTrue(driver.getTitle().equals("B&N | Homepage"));
*/	}

}
