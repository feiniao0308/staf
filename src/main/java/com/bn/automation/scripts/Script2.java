package com.bn.automation.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Script2 {

	//private static STAFDriver driver;

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
		System.out.println("hello");

		//driver.autopopulate("hello", this.getClass());
		//driver.setDataFileLocation("\\src\\test\\resources\\data\\xmlDataFormat.xml");
		/*driver.autopopulate("inputform", SO2.class);*/
		//System.out.println(Class.forName(""));
		//System.out.println("SO2"+getField("searchbar"));
		/*SO2 so = data SO2();
		so.searchbar.autoPopulate();
		SO2.searchbar.autoPopulate();
		data XMLReader().getContainer();
		//Assert.assertTrue(driver.getTitle().equals("B&N | Homepage"));
*/	}

}
