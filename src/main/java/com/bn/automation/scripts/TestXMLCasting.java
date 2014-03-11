package com.bn.automation.scripts;

import com.bn.automation.staf.anno.AfterMethod;
import com.bn.automation.staf.anno.BeforeMethod;
import com.bn.automation.staf.anno.STAFScript;
import com.bn.automation.staf.anno.Test;
import com.bn.automation.staf.core.STAFDriver;
import com.bn.automation.staf.core.STAFRunner;

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

	@Test(id = { 0 }, enabled = false)
	public void test() throws Throwable {
		
		System.out.println("hello from test method");

		System.out.println("hello from test method");
		
		
		STAFDriver sd = new STAFDriver();
		sd.get("http://google.com");
		Thread.sleep(1000);
		
		//System.out.println("congif : " + sd.getConfig().toString());
		
		/*System.out.println("1: " + sd.getConfig().getField("hello"));;
		System.out.println("2: " + sd.getConfig().getField("hello").getField().getAttributeValue("value"));;
		System.out.println("3: " + sd.getConfig().getField("hello").getField());;*/
		
	//	System.out.println("\t4: " + STAFRunner.getConfigXml().getField("hello"));
		
	//	System.out.println("\t4: " + STAFRunner.getConfigXml().getTag("field"));
	//	System.out.println("\t5: " + STAFRunner.getConfigXml().getTag("field").getAttributeValue("value"));
	//	System.out.println("\t6: " + STAFRunner.getConfigXml().getTag("field").getTagName("f").getAttributeValue("value"));

	//	System.out.println("\t7: " + STAFRunner.getConfigXml().getCookie("hello"));
		
		
		
		
		
		
		System.out.println("element value : " + sd.getConfig().getField2("hello").getAttributeValue("value"));
		
		
		//sd.getConfig().getDataContainer("he");
		
		
		
		sd.quit();

	}


}
