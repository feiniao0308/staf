package com.bn.automation.scripts;

import com.bn.automation.staf.anno.AfterMethod;
import com.bn.automation.staf.anno.BeforeMethod;
import com.bn.automation.staf.anno.STAFScript;
import com.bn.automation.staf.anno.Test;
import com.bn.automation.staf.core.STAFDriver;
import com.bn.automation.staf.widget.Label;

/**
 * Created by fdkzv on 3/27/14.
 */
@STAFScript
public class Hover {

    private static STAFDriver driver;

    @BeforeMethod
    public void setup() {
		driver = new STAFDriver();
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    @Test(id = { 0 }, enabled = true)
    public void test() throws Throwable {

       driver.get("http://qwecweb01.hq.bn-corp.com/bn/");
       new Label("id=shoppingBagLink").hover();
       Thread.sleep(5000);


	}
}
