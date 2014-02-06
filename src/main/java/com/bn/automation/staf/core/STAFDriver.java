package com.bn.automation.staf.core;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.bn.automation.staf.helpers.STAFConstant;
import com.bn.automation.staf.util.XMLReader;
import com.bn.automation.staf.widget.TextBox;
import com.bn.automation.staf.widget.Widgets;

public class STAFDriver implements STAFiDriver {

	public static WebDriver iDriver;
	private static String browser;
	private String testCaseID;
	private String dataFileLocation;
	private String URL;
	private static final Logger logger = LogManager.getLogger();
	private volatile static STAFDriver stafDriver = null;

	public STAFDriver(String browser) {

		switch (browser) {
		case STAFConstant.FIREFOX:
			setBrowser(STAFConstant.FIREFOX);
			iDriver = new FirefoxDriver();
			logger.info("Firefox browser is set and opened in new window");
			break;
		case STAFConstant.CHROME:
			setBrowser(STAFConstant.CHROME);
			iDriver = new ChromeDriver();
			logger.info("Chrome browser is set and opened in new window");
			break;
		case STAFConstant.IE:
			setBrowser(STAFConstant.IE);
			iDriver = new InternetExplorerDriver();
			logger.info("Internet Explorer browser is set and opened in new window");
			break;
		case STAFConstant.HTML_UNIT:
			setBrowser(STAFConstant.HTML_UNIT);
			iDriver = new HtmlUnitDriver();
			logger.info("HTML unit browser is set and opened in new window");
			break;
		case "other1":
		case "other2":
		default:
			throw new IllegalArgumentException("Invalid browser type : "
					+ browser);
		}

	}

	public STAFDriver(String browser, String dataFileLocation) {
		setDataFileLocation(dataFileLocation);
		switch (browser) {
		case STAFConstant.FIREFOX:
			iDriver = new FirefoxDriver();
			break;
		case STAFConstant.CHROME:
			iDriver = new ChromeDriver();
			break;
		case STAFConstant.IE:
			iDriver = new InternetExplorerDriver();
			break;
		case STAFConstant.HTML_UNIT:
			iDriver = new HtmlUnitDriver();
			break;
		case "other1":
		case "other2":
		default:
			throw new IllegalArgumentException("Invalid browser type : "
					+ browser);
		}
	}

	public static STAFDriver getInstance(String browser) {
		if (stafDriver == null) {
			stafDriver = new STAFDriver(browser);
		}
		return stafDriver;
	}

	public static STAFDriver getInstance() {

		if (stafDriver == null) {
			stafDriver = new STAFDriver(STAFConstant.FIREFOX);
			logger.debug("Firefox browser will be used if no browser name is passed to getInstance");
		}
		logger.debug("Browser selected is : " + getBrowser());
		return stafDriver;
	}

	@Override
	public void get(String url) {
		iDriver.get(url);

	}

	@Override
	public String getCurrentUrl() {
		return iDriver.getCurrentUrl();
	}

	@Override
	public String getTitle() {
		return iDriver.getTitle();
	}

	@Override
	public List<WebElement> findElements(By by) {
		return iDriver.findElements(by);
	}

	@Override
	public WebElement findElement(By by) {
		return iDriver.findElement(by);
	}

	@Override
	public String getPageSource() {
		return iDriver.getPageSource();
	}

	@Override
	public void close() {
		iDriver.close();
	}

	@Override
	public void quit() {
		iDriver.quit();
	}

	@Override
	public Set<String> getWindowHandles() {
		return iDriver.getWindowHandles();
	}

	@Override
	public String getWindowHandle() {
		return iDriver.getWindowHandle();
	}

	@Override
	public TargetLocator switchTo() {
		return iDriver.switchTo();
	}

	@Override
	public Navigation navigate() {
		return iDriver.navigate();
	}

	@Override
	public Options manage() {
		return iDriver.manage();
	}

	@Override
	public String getTestCaseID() {
		return logger.exit(this.testCaseID);
	}

	@Override
	public void setTestCaseID(String value) {
		logger.entry(value);
		this.testCaseID = value;
	}

	@Override
	public String getDataFileLocation() {
		return logger.exit(this.dataFileLocation);
	}

	@Override
	public void setDataFileLocation(String value) {
		logger.entry(value);
		this.dataFileLocation = value;
	}

	@Override
	public String getURL() {
		return logger.exit(this.URL);
	}

	@Override
	public void setURL(String value) {
		logger.entry(value);
		this.URL = value;
	}

	@Override
	public Object getDriver() {
		return null;

	}

	@Override
	public void setDriver() {
		// TODO Auto-generated method stub

	}
	
	public static String getBrowser() {
		return logger.exit(browser);
	}

	
	public static void setBrowser(String value) {
		logger.entry(value);
		browser = value;		
	}


	@SuppressWarnings({ "rawtypes", "unused" })
	@Override
	public void autopopulate(Object containerName, Class<?> className) throws Throwable {
		
		HashMap<String, String> populateData = new XMLReader().getContainer(containerName.toString());
		System.out.println(" maps is " + populateData);
		int i = 1;
		//((TextBox) className.getDeclaredField("fname").get(null)).sendKeys("karthik");
		Class cname = className;
		Field fname = className.getField("lname");
		//Class xclass = cname.class;
		System.out.println(className);
		Class innrClass = Class.forName("com.bn.automation.scripts.SO$SOinner");
		innrClass.getDeclaredField("lname").get(null);
		System.out.println("---------------");
		System.out.println(innrClass.getDeclaredField("lname").get(null));
		for(Map.Entry<String, String> entry:populateData.entrySet()){
			System.out.println(i);
			String s1 = entry.getKey();
			String s2 = entry.getValue();
			System.out.println(s1);
			System.out.println(s2);
			logger.debug("Field's Name : " +  s1 + " & Value : " + s2);
			//((TextBox) className.getDeclaredField(entry.getKey()).get(null)).sendKeys(entry.getValue());
			//Class cname = className;
			Field[] farray = cname.getFields();
			//Field[] farray = cname.get
			for(Field f:farray){
				System.out.println("field name is : " + f.getName());
				if(f.getName().equals(entry.getKey())){
					System.out.println("yes it is present");
					f.setAccessible(true);
					//f.get(f);
					System.out.println("param is  : " + f.get(null));
				}
			}
			//System.out.println(farray);
			
			//Field t1 = className.getDeclaredField(s1);
			//System.out.println(t1);
			//t1.get(null);
			//send(t1, s2);
			i++;
		}
		
		/*Iterator<Map.Entry<String, String>> entries = populateData.entrySet().iterator();
		while(entries.hasNext()){
			Map.Entry<String, String> entry = entries.next();
			((TextBox) className.getDeclaredField(entry.getKey()).get(null)).sendKeys(entry.getValue());
			i++;
		}*/
		
	}
	
	public void send(TextBox t1,String value){
		logger.entry(t1,value);
		System.out.println("inside send");
		t1.sendKeys(value);
		System.out.println("end of send");
	}
	
	public void autopopulate(Object containerName, Object SO) throws Throwable{
		Map<String, String> populateData = new XMLReader().getContainer(containerName.toString());
		
		Class<?> ScreenObject = SO.getClass();
		if(ScreenObject.getAnnotation( Widgets.class) != null){
			for(Map.Entry<String, String> entry:populateData.entrySet()){
				String s1 = entry.getKey();
				String s2 = entry.getValue();
				System.out.println(s1);
				System.out.println(s2);
				TextBox t = (TextBox) ScreenObject.getDeclaredField(s1).get(null);
				t.populate(s2);
			}
		}
		
		
	}

	
	

}
