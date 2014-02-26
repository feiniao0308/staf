package com.bn.automation.scripts;

import com.bn.automation.staf.core.STAFDriver;
import com.bn.automation.staf.helpers.STAFConstant;

public class ClickHoverElement {

	public static void main(String[] args) throws InterruptedException {
		STAFDriver driver = STAFDriver.getInstance(STAFConstant.FIREFOX);
		driver.get("http://qwecweb01.hq.bn-corp.com/bn/");
		driver.setTestCaseID("111");
		driver.setDataFileLocation("\\src\\test\\resources\\data\\xmlDataFormat.xml");
		//SO.SOinner.bnmyacc.hover();
		Thread.sleep(1000L);
		//driver.findElement(By.xpath(".//*[@id='myAccountLinks']/ul/li[1]/a")).click();

	}
}
