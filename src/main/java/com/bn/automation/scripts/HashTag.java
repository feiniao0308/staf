package com.bn.automation.scripts;

import com.bn.automation.staf.anno.AfterMethod;
import com.bn.automation.staf.anno.BeforeMethod;
import com.bn.automation.staf.anno.STAFScript;
import com.bn.automation.staf.anno.Test;
import com.bn.automation.staf.core.STAFDriver;
import com.bn.automation.staf.core.STAFRunner;
import com.bn.automation.staf.util.IDataContainer;

/**
 * Created by fdkzv on 3/12/14.
 */
@STAFScript
public class HashTag {

    private static STAFDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new STAFDriver();
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    @Test(id = { 145 }, enabled = true)
    public void test() throws Throwable {

        System.out.println("hello from test method");

        driver.get("http://www.iupui.edu/~webtrain/tutorials/forms_sample.html");

        SO2 so = new SO2();
        Thread.sleep(1000);
        driver.setData("\\src\\main\\resources\\data\\xmlDataFormat.xml");


        System.out.println("\t4: " + STAFRunner.getConfigXml().getField("hello"));
        System.out.println("\t5: " + STAFRunner.getDataXml().getField("hello"));


        System.out.println("\t6: " + driver.getConfig().getField("hello"));
        System.out.println("\t7: " + driver.getData().getField("hello"));
        System.out.println("\t8: " + driver.getData().getDataContainer("hello"));
        System.out.println("\t9: " + driver.getData().getDataContainer("hello").getField("element1"));
        System.out.println("\t10: " + driver.getData().getDataContainer("hello").get());
        IDataContainer data = driver.getData().getDataContainer("verifyform");
        driver.autoVerifyMap(data,so);



    }
}
