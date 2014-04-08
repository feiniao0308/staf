package com.bn.automation.scripts;

import com.bn.automation.staf.anno.AfterMethod;
import com.bn.automation.staf.anno.BeforeMethod;
import com.bn.automation.staf.anno.Test;
import com.bn.automation.staf.core.STAFDriver;

/**
 * Created by fdkzv on 4/3/14.
 */
public class eom {

    public STAFDriver driver;
    @BeforeMethod
    public void setup() {
        driver = new STAFDriver();
        driver.get("http://qwecdom01.hq.bn-corp.com:30000/ ");




    }

    @AfterMethod
    public void tearDown() {


    }

    @Test(id = {4}, enabled = true)
    public void keywordDrivenTest() throws Throwable {





    }
}
