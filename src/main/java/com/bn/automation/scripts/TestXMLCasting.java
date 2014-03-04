package com.bn.automation.scripts;

import com.bn.automation.staf.anno.AfterMethod;
import com.bn.automation.staf.anno.BeforeMethod;
import com.bn.automation.staf.anno.STAFScript;
import com.bn.automation.staf.anno.Test;
import com.bn.automation.staf.core.STAFDriver;

@STAFScript
public class TestXMLCasting {
	
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

		System.out.println("hello from test method");
		
		STAFDriver sd = new STAFDriver();
		sd.get("http://google.com");
		Thread.sleep(1000);
		
		//System.out.println("congif : " + sd.getConfig().toString());
		
		sd.getConfig().getField("hello");
		
		
		//sd.getConfig().getDataContainer("he");
		
		
		
		sd.quit();

	}


}
