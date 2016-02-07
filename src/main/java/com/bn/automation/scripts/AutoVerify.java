package com.bn.automation.scripts;

import com.bn.automation.staf.anno.AfterMethod;
import com.bn.automation.staf.anno.BeforeMethod;
import com.bn.automation.staf.anno.STAFScript;
import com.bn.automation.staf.anno.Test;
import com.bn.automation.staf.core.STAFDriver;
import com.bn.automation.staf.util.IDataContainer;

/**
 * Created by fdkzv on 3/25/14.
 */
@STAFScript
public class AutoVerify {

    private static STAFDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new STAFDriver();
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    @Test(id = {145}, enabled = true)
    public void keywordDrivenTest() throws Throwable {

        System.out.println("hello from test method");

        driver.get("http://www.iupui.edu/~webtrain/tutorials/forms_sample.html");

        SO2 so = new SO2();
        Thread.sleep(1000);
        driver.setData("data/xmlDataFormat.xml");


        IDataContainer data = driver.getData().getDataContainer("verifyform");
        driver.autoVerify(data, so);


    }
}
