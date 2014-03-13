package com.bn.automation.scripts;



import com.bn.automation.staf.anno.AfterMethod;
import com.bn.automation.staf.anno.BeforeMethod;
import com.bn.automation.staf.anno.STAFScript;
import com.bn.automation.staf.anno.Test;
import com.bn.automation.staf.core.STAFDriver;

@STAFScript
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

	@Test(id = { 0 })
	public void test() throws Throwable {
		
		System.out.println("hello from test method");
		
		STAFDriver sd = new STAFDriver();
		sd.get("http://google.com");
		Thread.sleep(5000);
		sd.quit();
		
		
		/*System.out.println("hello");

		//driver.autopopulate("hello", this.getClass());
		driver.setDataFileLocation("\\src\\test\\resources\\data\\xmlDataFormat.xml");
		driver.autopopulate("inputform", SO2.class);
		//System.out.println(Class.forName(""));
		//System.out.println("SO2"+getField("searchbar"));
		SO2 so = data SO2();
		so.searchbar.autoPopulate();
		SO2.searchbar.autoPopulate();
		data XMLReader().getContainer();
		//Assert.assertTrue(driver.getTitle().equals("B&N | Homepage"));
*/	}

}
