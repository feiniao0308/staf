package com.bn.automation.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.bn.automation.staf.core.STAFDriver;
import com.bn.automation.staf.helpers.STAFConstant;


public class Reflect {
	  public static final String CONSTANT_1 = "1";
	  public static final String CONSTANT_2 = "2";
	  public static final String CONSTANT_3 = "3";

	  @Test
	  public void test() throws Throwable{
		  STAFDriver driver = STAFDriver.getInstance(STAFConstant.FIREFOX);
		  SO so = new SO();
		  driver.get("http://www.iupui.edu/~webtrain/tutorials/forms_sample.html");
		  driver.setTestCaseID("124");
		  driver.setDataFileLocation("\\src\\test\\resources\\data\\xmlDataFormat.xml");
		  Thread.sleep(5000L);
		  //SO.SOinner.name.populate("karth");
		  SO.SOinner.name.sendKeys("karthj");
		  //driver.autopopulate("inputform", so);
		  driver.findElement(By.name("name"));
		  
	  }
	  
	  public static void main(String[] args) throws Exception {
		  System.out.println("Hello world!!");
		  
		  
		  //SO so = new SO();
		  
		  //so.fname.autoPopulate();
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
	    //Class clazz = Class.forName("com.bn.automation.scripts.SO$SOinner");
	    //Class[] cin = Class.forName("com.bn.automation.scripts.SO").getClasses();
	    //System.out.println(cin[0].getDeclaredField("lname").get(null));
	    //System.out.println();
	    //Object obf = cin[0].newInstance();
	   // Field f1 = obj.get
	  //  TextBox t1 = (TextBox) cin[0].getField("fname").get(null);
	    /*Field[] fields = clazz.getDeclaredFields();
	    int i=1;
	    for(Field f: fields) {
	      // for fields that are visible (e.g. private)
	      f.setAccessible(true);
	     System.out.println(i);
	      // note: get(null) for static field
	      System.out.printf("%s: %s\n",f, (String)f.get(null) );
	      i++;
	    }*/
	  }
	}
