package com.bn.automation.scripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.bn.automation.staf.helpers.STAFConstant;

public class GridScriptFF {
	
	public static WebDriver driver;

	public static void main(String[] args) throws MalformedURLException,
			InterruptedException {

		String browser = String.valueOf(System.getProperty("browser"));
		System.out.println("Browser name passed is : " + browser);
		if (browser.toLowerCase().equals(STAFConstant.FIREFOX.toLowerCase())) {
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			driver = new RemoteWebDriver(new URL(
					"http://localhost:4444/wd/hub"), capability);

		}
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		Thread.sleep(5000L);
		driver.quit();
	}

}
