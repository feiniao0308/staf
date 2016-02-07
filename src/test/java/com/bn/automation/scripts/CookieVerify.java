package com.bn.automation.scripts;

import org.openqa.selenium.By;

import com.bn.automation.scripts.SO2.SOinner;
import com.bn.automation.staf.core.STAFDriver;
import com.bn.automation.staf.helpers.STAFConstant;

public class CookieVerify {

	public static void main(String[] args) throws Throwable {
		STAFDriver driver = STAFDriver.getInstance(STAFConstant.FIREFOX);
		driver.get("http://qwecweb01.hq.bn-corp.com/bn/");
		driver.setTestCaseID("167");
		driver.setDataFileLocation("\\src\\test\\resources\\data\\xmlDataFormat.xml");
		driver.findElement(By.id("signInLink")).click();
		Thread.sleep(1000L);
		SO2 so = new SO2();
		driver.autopopulate("loginbn", so);
		Thread.sleep(1000L);
		SOinner.emailbn.submit();
		Thread.sleep(2000L);
		
		driver.cookieVerify("cookiebn");
		/*Set<Cookie> cookies = driver.manage().getCookies();
        Iterator<Cookie> itr = cookies.iterator();

        while (itr.hasNext())
        {
            Cookie c = itr.next();
            System.out.println("--------------------->");
            System.out.println("Cookie Name: " + c.getName()  + "\nCookie Domain: " + c.getDomain() +  "\nCookie Value: " + c.getValue() +  "\nPath: " + c.getPath()+  "\nExpiry Date: " + c.getExpiry()+  "\nSecure: " + c.isSecure());
            System.out.println("<-------------------\n");
        }*/
	}
	
}
